package net.projectsync.redis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import net.projectsync.redis.model.Product;
import net.projectsync.redis.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    /**
     * Get product by id from DB. If price <= 1000, then cache the product in Redis cache as well
     *
     * key = "#id"                      -> spring expression. id
     * value = "Product"                -> hash key (private static final String HASH_KEY = "Product";)
     * unless = "#result.price > 1000"  -> if price <= 1000 -> First time: fetch from DB and store result in cache. From second request onwards, fetch data from cache
     *                                     if price > 1000  -> DON'T put objects in cache and fetch data directly from DB
     */
    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
    
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    /**
     * return value ignored for HttpStatus.NO_CONTENT
     * Delete product by id from DB. If that product is cached in Redis cache, remove that product from cache as well
     */
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProductById(int id) {
        return productRepository.deleteProductById(id);
    }
}


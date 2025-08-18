package net.projectsync.redis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
    
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public String deleteProductById(int id) {
        return productRepository.deleteProductById(id);
    }
}


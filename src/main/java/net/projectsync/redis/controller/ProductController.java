package net.projectsync.redis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import net.projectsync.redis.model.Product;
import net.projectsync.redis.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	return productService.createProduct(product);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product getProductById(@PathVariable int id) {
    	return productService.getProductById(id);
    }
    
	@ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Product> getProducts() {
		return productService.getProducts();
    }

	/// return value ignored for HttpStatus.NO_CONTENT
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);	        
    }
}


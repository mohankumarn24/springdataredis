package net.projectsync.redis.controller;

import net.projectsync.redis.model.Product;
import net.projectsync.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    // @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product getProductById(@PathVariable int id) {
    	return productService.getProductById(id);
    }

	@ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Product> getProducts() {
		return productService.getProducts();
    }

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    // @CacheEvict(key = "#id", value = "Product")
    public String deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);	        
    }
}

/**
 * In this example, Redis is used as DB as well as cache
 * CachePut --> Update
 */
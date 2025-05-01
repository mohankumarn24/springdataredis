package com.javatechie.redis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatechie.redis.model.Product;
import com.javatechie.redis.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
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


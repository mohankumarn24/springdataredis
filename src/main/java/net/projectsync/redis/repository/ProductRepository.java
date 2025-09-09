package net.projectsync.redis.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import net.projectsync.redis.model.Product;

/**
 * In this example we are saving product object in Redis. We are using Redis as DB and cache as well
 */
@Repository
public class ProductRepository {

	private final Logger logger = LoggerFactory.getLogger(ProductRepository.class);
    private static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;

    public Product createProduct(Product product) {

        template.opsForHash().put(HASH_KEY, product.getId(), product);
        logger.info(String.format("Product with ID %s saved to DB", product.getId()));
        return product;
    }

    public Product getProductById(int id) {

        System.out.println("called findProductById() from DB");
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }
    
    public List<Product> getProducts() {

        logger.info(String.format("Fetching all products from DB"));
        return template.opsForHash().values(HASH_KEY);
    }

    public String deleteProductById(int id) {

    	template.opsForHash().delete(HASH_KEY, id);
        logger.info(String.format("Product with ID %s deleted from DB", id));
        return "product removed !!";
    }
}


package net.projectsync.redis.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import net.projectsync.redis.model.Product;

@Repository
public class ProductRepository {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;

    public Product addProduct(Product product){
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public Product getProductById(int id){
        System.out.println("called findProductById() from DB");
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }
    
    public List<Product> getProducts(){
        return template.opsForHash().values(HASH_KEY);
    }

    public String deleteProductById(int id){
         template.opsForHash().delete(HASH_KEY, id);
        return "product removed !!";
    }
}


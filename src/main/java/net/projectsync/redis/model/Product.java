package net.projectsync.redis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@RedisHash("Product")
public class Product implements Serializable {
	
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;
    
    public Product() {
    	
    }
    
	public Product(String name, int qty, long price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
}


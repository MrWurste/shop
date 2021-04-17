package com.sda.shop.dao;

import com.sda.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT * FROM Products",
                new ProductMapper());
    }

    public void addProduct(Product p) {
        jdbcTemplate.update("INSERT INTO Products (name, description, image, price) VALUES (?,?,?,?)", p.getName(), p.getDescription(), p.getImage(), p.getPrice());
    }

    public void removeProductByID(Product product) {
        jdbcTemplate.execute("DELETE FROM Products WHERE id="+product.getId());
    }
}

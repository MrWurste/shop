package com.sda.shop.dao;

import com.sda.shop.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Item> getAllItems() {
        return jdbcTemplate.query("SELECT * FROM Items",
                new ItemMapper());
    }

    public void addItem(Item item) {
        jdbcTemplate.update("INSERT INTO Items (name, description, image, price) VALUES (?,?,?,?)", item.getName(), item.getDescription(), item.getImage(), item.getPrice());
    }

    public void removeItemByID(Item item) {
        jdbcTemplate.execute("DELETE FROM Items WHERE id="+item.getId());
    }
}

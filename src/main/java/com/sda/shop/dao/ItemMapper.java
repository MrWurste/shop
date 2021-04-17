package com.sda.shop.dao;

import com.sda.shop.models.Item;
import com.sda.shop.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setImage(rs.getString("image"));
        item.setPrice(rs.getDouble("price"));
        return item;
    }
}

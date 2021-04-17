package com.sda.shop.services;

import com.sda.shop.dao.ItemDAO;
import com.sda.shop.models.Item;
import com.sda.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServise {

    @Autowired
    ItemDAO itemDAO;

    public List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public void addItem (Item item) {
        itemDAO.addItem(item);
    }

    public void removeItemByID(Item item) {
        itemDAO.removeItemByID(item);
    }
}

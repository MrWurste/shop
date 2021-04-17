package com.sda.shop.services;

import com.sda.shop.models.Product;
import com.sda.shop.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServise {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void addProduct (Product product) {
        productDAO.addProduct(product);
    }

    public void removeProductByID(Product product) {
        productDAO.removeProductByID(product);
    }
}

package com.sda.shop.models;

public class CartProduct {

    private Long productId;
    private String productName;
    private String productQuantity;

    public CartProduct() {
    }

    public CartProduct(Long productId, String productName, String productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}

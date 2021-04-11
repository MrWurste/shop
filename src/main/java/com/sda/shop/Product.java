package com.sda.shop;

public class Product {
    public static int ID_GENERATOR = 0;
    private long id;
    private String name;
    private String description;
    private String image;
    private double price;

    public Product() {
        this.id = ID_GENERATOR++;
    }

    public Product(String name, String description, String image, double price) {
        this.id = ID_GENERATOR++;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }
}

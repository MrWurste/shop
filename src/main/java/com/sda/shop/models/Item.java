package com.sda.shop.models;

public class Item {
//    public static long ID_GENERATOR = 0;
    private long id;
    private String name;
    private String description;
    private String image;
    private double price;

    public Item() {
//        this.id = ID_GENERATOR++;
    }

    public Item(String name, String description, String image, int price) {
//        this.id = ID_GENERATOR++;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}

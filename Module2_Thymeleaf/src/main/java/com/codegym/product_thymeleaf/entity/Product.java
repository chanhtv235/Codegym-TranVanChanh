package com.codegym.product_thymeleaf.entity;

public class Product {
    private String nameProduct;
    private float price;
    private float discount;

    public Product() {
    }

    public Product(String nameProduct, float price, float discount) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.discount = discount;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

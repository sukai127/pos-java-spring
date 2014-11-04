package com.thoughtworks.iamcoach.pos.model;

import java.util.List;

public class Product {

    private int id;
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private Category category;
    private List<Promotion> promotions;

    public Product() {

    }

    public Product(int id,String barcode, String name, String unit, double price,Category category, List<Promotion> promotions) {

        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.category = category;
        this.promotions = promotions;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}

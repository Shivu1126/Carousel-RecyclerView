package com.androidwithshiv.carousel.model;

public class BatDetails {
    private int id;
    private String name;
    private String price;
    private boolean isFavrt;

    public BatDetails(int id, String name, String price, boolean isFavrt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isFavrt = isFavrt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isFavrt() {
        return isFavrt;
    }

    public void setFavrt(boolean favrt) {
        isFavrt = favrt;
    }
}

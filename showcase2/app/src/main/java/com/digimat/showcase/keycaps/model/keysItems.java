package com.digimat.showcase.keycaps.model;

public class keysItems {
    String name;
    double price;
    float rating;
    int imageResId;

    public keysItems(String name, double price, float rating, int imageResId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}

package com.mylesson.stage2.oop.interfaces;

import java.io.Serializable;

public class Pizza implements Priceble, Serializable {

    private String name;
    private int quantity;
    private int price;
    private Size size;

    public String getName() {
        return name;
    }
    @Override
    public int calcOrderPrice() {
        Priceble.doSmth();
        return quantity * price;
    }
    @Override
    public int calcDeliveryPrice() {

        if((size == Size.XL)||(quantity > 1)){
            return 0;
        } else {
            return 7;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Pizza(String name, int quantity, int price, Size size) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }
}

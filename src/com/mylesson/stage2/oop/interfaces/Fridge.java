package com.mylesson.stage2.oop.interfaces;

public class Fridge extends Electronics{
    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 300) {
            return 0;

        } else {
            return 50;
        }
    }

    @Override
    public int calcOrderPrice() {
        return getQuantity() * getPrice();
    }

    public Fridge(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }
}

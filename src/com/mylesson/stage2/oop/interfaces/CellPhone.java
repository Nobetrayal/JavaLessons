package com.mylesson.stage2.oop.interfaces;

public class CellPhone extends Electronics {
    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 150) {
            return 0;

        } else {
            return 10;
        }
    }
    @Override
    public int calcOrderPrice() {
        return getQuantity() * getPrice();
    }
    public CellPhone(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }
}

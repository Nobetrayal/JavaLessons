package com.mylesson.stage2.oop.interfaces;


public class InterfaceRunner {

    public static void main(String[] args) {

       //  Deliverable[] deliverable = new Deliverable[3];// Можно созать массив, но не объект.

        Priceble pizza = new Pizza("Neapolitana", 1, 15, Size.L);

        Priceble phone = new CellPhone("Moto", "w220", 1, 250);

        Priceble fridge = new Fridge("LG", "9887", 1, 300);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);

    }

    private static void printDeliveryPrice(Priceble deliverable){
        System.out.println("Delivery price " + deliverable.calcDeliveryPrice());
        System.out.println("Order price " + deliverable.calcOrderPrice());
    }

}

package com.mylesson.stage2.oop.interfaces;

public interface Priceble extends Deliverable, Orderable{

    default int calcPrice(){
       return calcOrderPrice() + calcDeliveryPrice();
    }
    static void doSmth(){

    }

}

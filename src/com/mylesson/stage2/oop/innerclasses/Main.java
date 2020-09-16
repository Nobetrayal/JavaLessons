package com.mylesson.stage2.oop.innerclasses;

public class Main {
    public static void main(String[] args) {
        CellPhone phone = new CellPhone("Moto", "W220");
        phone.turnOn();
        phone.call("1234567890");
        Display display = phone.getDisplay();
//        Display.Pixel pixel = display.new Pixel(1009090, 100, Display.Color.RED); // Для не статик вложенного класса.
    //    Display.Pixel pixel = new Display.Pixel(123,123, Display.Color.GREEN); // Если паблик статик.
    }

}

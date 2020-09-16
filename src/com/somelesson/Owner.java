package com.somelesson;

public class Owner {

    String name;

    public void strokeCat(Cat cat) {

        System.out.println(name + " stroking " + cat.getName());
        cat.sayMeow();
    }

}

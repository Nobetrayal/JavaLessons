package com.somelesson;

public class Cat extends Animal {

    private String name;
    private String mood;


    public Cat() {



    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }


    public void setAge(int age) {

        if (age > 0 && age < 30) {
            this.age = age;
        }

    }

    public void sayMeow(){

        System.out.println(name + " says Meow");

    }

    @Override
    public void makeNoise() {

        sayMeow();

    }

    private class Mustache{

        int length;

    }

}

package com.somelesson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        Animal myCat = new Cat("Tawi", 3);
//        myCat.setMood("rainy");

        Owner owner = new Owner();
        owner.name = "Maks";

//        owner.strokeCat(myCat);

        Animal dog = new Dog();

//        myCat.makeNoise();
//        dog.makeNoise();

        Animal duck = new Duck();

        List<Animal> animals = new ArrayList<>();
        animals.add(myCat);
        animals.add(dog);
        animals.add(duck);

        for (Animal animal: animals) {

            animal.makeNoise();

        }

    }


}

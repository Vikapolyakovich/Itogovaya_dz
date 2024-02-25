package org.example.service;

import org.example.data.Cat;
import org.example.data.Dog;
import org.example.data.Hamster;
import org.example.data.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PetList <Object> {
    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();
    private List<Hamster> hamsters = new ArrayList<>();


//     добавить кота в список
    public void addCat(Cat cat) {
        cats.add(cat);
    }

//    Получить список котов
    public void getCats(){
        for (Cat cat: cats) {
            System.out.println(cat);
        }
    }

    //     добавить собаку в список
    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    //    Получить список собак
    public void getDogs(){
        for (Dog dog: dogs) {
            System.out.println(dog);
        }
    }

    //     добавить хомяка в список
    public void addHamster(Hamster hamster) {
        hamsters.add(hamster);
    }

    //    Получить список хомяков
    public void getHamsters(){
        for (Hamster hamster: hamsters) {
            System.out.println(hamster);
        }
    }

    public Pet findPet(String name) {
        Cat cat = null;
        try {
            cat = cats.stream().filter(c -> c.getName().equals(name)).findFirst().get();


        }
        catch (NoSuchElementException ex) {
            cat = null;
        }
        Dog dog = null;
        try {
            dog = dogs.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex) {
            dog = null;
        }
        Hamster hamster = null;
        try {
            hamster = hamsters.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        }
        catch (NoSuchElementException ex) {
            hamster = null;
        }

        if (cat != null) {
            return cat;
        }
        else if (dog != null) {
            return dog;
        }
        else if (hamster != null) {
            return hamster;
        }
        else
            System.out.println("Животное не найдено");
            return null;
    }

}

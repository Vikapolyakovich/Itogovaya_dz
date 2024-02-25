package org.example.controller;

import org.example.data.Cat;
import org.example.data.Dog;
import org.example.data.Hamster;
import org.example.data.Pet;
import org.example.service.CounterPet;
import org.example.service.PetList;
import org.example.service.PetService;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class PetController {
    PetList<Object> petList = new PetList<>();
    PetService petService = new PetService();
    Scanner scanner = new Scanner(System.in);

    public void createAnimal() {
        try (CounterPet counter = new CounterPet()) {
            counter.add();
        } catch (IOException e) {
            System.out.println("Неверное состояния счетчика");
            e.printStackTrace();
        }
        System.out.println("Какое животное создать? 1-кот, 2-собака, 3-хомяк: ");
        int strtype = scanner.nextInt();

        if (strtype == 1) {
            Cat cat = new Cat();
            System.out.println("Введите имя питомца: ");
            String strname = scanner.next();
            cat.setName(petService.validateName(strname));
            System.out.println("Введите дату рождения питомца в формате dd.mm.yyyy: ");
            String strbirth = scanner.next();
            cat.setBirthday(petService.validateDateBirth(strbirth));
            petList.addCat(cat);
        }
        if (strtype == 2) {
            Dog dog = new Dog();
            System.out.println("Введите имя питомца: ");
            String strname = scanner.next();
            dog.setName(petService.validateName(strname));
            System.out.println("Введите дату рождения питомца в формате dd.mm.yyyy: ");
            String strbirth = scanner.next();
            dog.setBirthday(petService.validateDateBirth(strbirth));
            petList.addDog(dog);
        }
        if (strtype == 3) {
            Hamster hamster = new Hamster();
            System.out.println("Введите имя питомца: ");
            String strname = scanner.next();
            hamster.setName(petService.validateName(strname));
            System.out.println("Введите дату рождения питомца в формате dd.mm.yyyy: ");
            String strbirth = scanner.next();
            hamster.setBirthday(petService.validateDateBirth(strbirth));
            petList.addHamster(hamster);
        }
        System.out.println("Животное успешно создано!");
    }

    public void getAnimals() {
        petList.getCats();
        petList.getDogs();
        petList.getHamsters();
    }

    public void addCommand() {
        System.out.println("Введите имя животного, кому надо добавить команду: ");
        String strname = scanner.next();
        Pet pet = petList.findPet(strname);
        if (pet!=null) {
            System.out.println("Введите комманду, чтобы добавить: ");
            String strcommand = scanner.next();
            pet.addCommand(strcommand);
            System.out.println("Команда успешно добавлена! "+ pet);
        }
    }

    public void getCommand() {
        System.out.println("Введите имя животного, чтобы посмотреть комманды: ");
        String strname = scanner.next();
        Pet pet = petList.findPet(strname);
        if (pet!=null) {
            pet.getCommand();
        }
    }

    public int getCounter() {
        int res;
        try (CounterPet counter = new CounterPet()) {
            res = counter.getCounter();
        }
        System.out.println(res);
        return res;
    }
}

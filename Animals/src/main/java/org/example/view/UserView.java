package org.example.view;

import org.example.controller.PetController;

import java.util.Scanner;

public class UserView {
    PetController petController = new PetController();
    Scanner scanner = new Scanner(System.in);
    public void run() {
        Boolean flag = true;
        while (flag) {
            System.out.println("0 - Выход, 1 - добавить животное, 2 - Добавить команду, 3 - Показать список команд, которое выполняет животное, 4 - Показать список животных, 5 - Показать кол-во животных");
            int strtype = scanner.nextInt();
            if (strtype == 0) {
                flag = false;
            }
            if (strtype == 1) {
                petController.createAnimal();
            }
            if (strtype == 2) {
                petController.addCommand();
            }
            if (strtype == 3) {
                petController.getCommand();
            }
            if (strtype == 4) {
                petController.getAnimals();
            }
            if (strtype == 5) {
                petController.getCounter();
            }
        }
    }
}

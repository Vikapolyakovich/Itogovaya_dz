package org.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PetService {
    Scanner in = new Scanner(System.in);

    public String validateName(String name) {
        if (name.length() <= 1) {
            System.out.println("Имя "+ name+ " слишком короткое. Введите корректное значение: ");
            validateName(in.next());
        }
        if (name.length() >= 50) {
            System.out.println("Имя "+ name+ " слишком длинное. Введите корректное значение: ");
            validateName(in.next());
        }
        else {
            return name;
        }
        return null;
    }

    public Date validateDateBirth(String datebirth) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            Date date = format.parse(datebirth);
            return date;
        } catch (ParseException e) {
            System.out.println("Неверная дата. Введите дату в формате: dd.mm.yyyy");
            String strdate = in.nextLine();
            validateDateBirth(strdate);
        }
        return null;
    }
}

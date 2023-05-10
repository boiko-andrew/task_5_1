package ru.netology;

import ru.netology.person.Person;
import ru.netology.person.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        // Create valid objects
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person dad = new PersonBuilder()
                .setName("Павел")
                .setSurname("Дуров")
                .build();

        // Create child object for mom
        Person son = mom.newChildBuilder().
                setName("Антошка").
                build();

        // Create invalid object: required fields are missed
        try {
            Person foo = new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // Create invalid object: wrong age value is provided
        try {
            Person bar = new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(mom);
        System.out.println(dad);
        System.out.println(son);
        System.out.println("У " + mom + " есть сын, \n" + son);

        // Test happyBirthday method
        System.out.println();
        mom.happyBirthday();
        dad.happyBirthday();
        System.out.println(mom);
        System.out.println(dad);
    }
}
package ru.netology.person;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age; // optional
    private String address; // optional

    public PersonBuilder() {
        this.name = "";
        this.surname = "";
        this.age = OptionalInt.empty();
        this.address = "";
    }

    public String getName() {
        if (this.name.isEmpty()) {
            throw new IllegalStateException("Person's name cannot be empty.");
        }
        return name;
    }

    public String getSurname() {
        if (this.surname.isEmpty()) {
            throw new IllegalStateException("Person's surname cannot be empty.");
        }
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods for required fields
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    // Setter methods for optional fields
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Person's age cannot be negative.");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Build the Person object
    public Person build() {
        if (this.name.isEmpty()) {
            throw new IllegalStateException("Person's name cannot be empty.");
        }
        if (this.surname.isEmpty()) {
            throw new IllegalStateException("Person's surname cannot be empty.");
        }

        return new Person(this);
    }
}
package ru.netology.person;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age; // optional
    protected String address; // optional

    Person(PersonBuilder personBuilder) {
        name = personBuilder.getName();
        surname = personBuilder.getSurname();
        age = personBuilder.getAge();
        address = personBuilder.getAddress();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder()
                .setSurname(this.getSurname())
                .setAge(0)
                .setAddress(this.getAddress());

        return childBuilder;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (this.age.isPresent()) {
            return age.getAsInt();
        } else {
            System.out.println("Age is not defined.");
            return -1;
        }
    }

    public String getAddress() {
        if (this.address.isEmpty()) {
            System.out.println("Address is not defined.");
        }
        return address;
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        return !this.address.isEmpty();
    }

    public void happyBirthday() {
        if (this.age.isPresent()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        String result;
        result = "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'';

        if (this.age.isPresent()) {
            result += ", age=" + age.getAsInt();
        }

        if (this.hasAddress()) {
            result += ", address='" + address + '\'';
        }

        result += '}';

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
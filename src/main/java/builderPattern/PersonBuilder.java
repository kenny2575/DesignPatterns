package builderPattern;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String city;

    public PersonBuilder setName(String name) {
        if (this.name != null && !this.name.isEmpty()) {
            throw new IllegalArgumentException("Name is not empty. You can't change it");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (this.surname != null && !this.surname.isEmpty()) {
            throw new IllegalArgumentException("Surname is not empty. You can't change it");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (this.age != null && !this.age.isEmpty()) {
            throw new IllegalArgumentException("Age is not empty. You can't change it");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null || this.name.isEmpty() || this.surname.isEmpty()) {
            throw new IllegalStateException("Name or surname is empty");
        }
        try {
            if (!this.age.isEmpty() && this.age.isPresent() && this.age.getAsInt() < 0) {
                throw new IllegalArgumentException("Age must be above zero");
            }
        } catch (NullPointerException e) {
            this.age = OptionalInt.empty();
        }
        Person person = new Person(this.name, this.surname, this.age);
        person.setAddress(this.city);
        return person;
    }
}

package builderPattern;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;

    private OptionalInt age;

    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAge(0)
                .setAddress(getAddress());
    }

    @Override
    public String toString() {
        String strAge;
        if (hasAge()) {
            strAge = "" + age.getAsInt();
        } else {
            strAge = "не указан";
        }
        return "Person {" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", age = " + strAge +
                ", address = '" + city + '\'' +
                "}\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}

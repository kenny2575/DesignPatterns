package builderPattern;

import org.hamcrest.collection.IsIn;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.core.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalInt;
import java.util.stream.Stream;

public class PersonTest {

    Person sut;

    @BeforeAll
    static void init() {
        System.out.println("Tests start");
    }

    @Test
    void testPersonConstructorWithParams() {
        sut = new Person("TestName", "TestSurname");
        assertThat(sut, new IsInstanceOf(Person.class));
    }

    @ParameterizedTest
    @MethodSource
    void testPersonNameSurnameGetter(String name, String surname) {
        sut = new Person(name, surname);
        assertEquals(sut.getName(), name);
        assertEquals(sut.getSurname(), surname);
    }

    private static Stream<Arguments> testPersonNameSurnameGetter() {
        return Stream.of(
                Arguments.of("Name1", "Surname1"),
                Arguments.of("Troy", "Shekel")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testPersonNameSurnameAgeGetter(String name, String surname, OptionalInt age) {
        sut = new Person(name, surname, age);
        assertEquals(sut.getName(), name);
        assertEquals(sut.getSurname(), surname);
        assertTrue(sut.getAge().equals(age));
    }

    private static Stream<Arguments> testPersonNameSurnameAgeGetter() {
        return Stream.of(
                Arguments.of("name 1", "surname 1", OptionalInt.of(23)),
                Arguments.of("name 2", "surname 2", OptionalInt.of(45)),
                Arguments.of("name 3", "surname 3", OptionalInt.of(-100)),
                Arguments.of("name 4", "surname 4", OptionalInt.of(43)),
                Arguments.of("name 5", "surname 5", OptionalInt.of(0)),
                Arguments.of("name 6", "surname 6", OptionalInt.empty())
        );
    }

    @ParameterizedTest
    @MethodSource
    void testHasAge(Person person, boolean hasAge) {
        assertEquals(person.hasAge(), hasAge);
    }

    private static Stream<Arguments> testHasAge() {
        return Stream.of(
                Arguments.of(new Person("John", "Wick"), false),
                Arguments.of(new Person("Alfred", "Goodspeed", OptionalInt.of(23)), true)
        );
    }

    @Test
    void testHappyBirthday() {
        sut = new Person("Name", "Surname", OptionalInt.of(24));
        sut.happyBirthday();
        assertEquals(sut.getAge().getAsInt(), 25);

    }

    @Test
    void testSetGetAddress() {
        sut = new Person("Name", "Surname", OptionalInt.of(24));
        String city = "Test City";
        sut.setAddress(city);
        assertEquals(sut.getAddress(), city);
    }

    @Test
    void testNewChildBuilderReturningType() {
        sut = new Person("Name", "Surname", OptionalInt.of(24));
        assertThat(sut.newChildBuilder(), new IsInstanceOf(PersonBuilder.class));
    }

    @AfterAll
    static void finish() {
        System.out.println("Tests finished");
    }

}
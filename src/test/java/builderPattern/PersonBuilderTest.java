package builderPattern;

import org.hamcrest.collection.IsIn;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonBuilderTest {
    PersonBuilder sut;

    @BeforeAll
    static void init() {
        System.out.println("Start PersonBuilder tests");
    }

    @BeforeEach
    void beforeEach() {
        sut = new PersonBuilder();
    }

    @Test
    void testSetNameReturningType() {
        assertThat(sut.setName("Name"), new IsInstanceOf(PersonBuilder.class));
    }

    @Test
    void testSetSurnameReturningType() {
        assertThat(sut.setSurname("Surname"), new IsInstanceOf(PersonBuilder.class));
    }

    @Test
    void testSetAgeReturningType() {
        assertThat(sut.setAge(93), new IsInstanceOf(PersonBuilder.class));
    }

    @Test
    void testSetAddressReturningType() {
        assertThat(sut.setAddress("City of dreams"), new IsInstanceOf(PersonBuilder.class));
    }

    @Test
    void testBuildReturningType() {
        assertThat(sut.setName("Name").setSurname("Surname").build(), new IsInstanceOf(Person.class));
    }

    @ParameterizedTest
    @MethodSource("testThrowIllegalStateExceptionArguments")
    void testThrowIllegalStateException(String name, String surname, int age, String city) {
        var expected = IllegalStateException.class;

        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setAge(age).setAddress(city).build());
    }

    @ParameterizedTest
    @MethodSource("testThrowIllegalStateExceptionArguments")
    void testThrowIllegalStateExceptionWithoutAge(String name, String surname, int age, String city) {
        var expected = IllegalStateException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setAddress(city).build());
    }

    @ParameterizedTest
    @MethodSource("testThrowIllegalStateExceptionArguments")
    void testThrowIllegalStateExceptionWithoutCity(String name, String surname, int age, String city) {
        var expected = IllegalStateException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setAge(age).build());
    }

    @ParameterizedTest
    @MethodSource("testThrowIllegalStateExceptionArguments")
    void testThrowIllegalStateExceptionWithoutAgeAndCity(String name, String surname, int age, String city) {
        var expected = IllegalStateException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).build());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "alex, turner",
            "brian, white",
            "charles, smith"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testThrowIllegalArgumentExceptionWithDoubleNames(String name, String surname) {
        var expected = IllegalArgumentException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setName(name).build());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "alex, turner",
            "brian, white",
            "charles, smith"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testThrowIllegalArgumentExceptionWithDoubleSurnames(String name, String surname) {
        var expected = IllegalArgumentException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setSurname(name).build());
    }

    @ParameterizedTest
    @MethodSource("testThrowIllegalStateExceptionArguments")
    void testThrowIllegalArgumentExceptionWithDoubleAges(String name, String surname, int age, String city) {
        var expected = IllegalArgumentException.class;
        assertThrows(expected,
                () -> sut.setName(name).setSurname(surname).setAge(age).setAge(age).setAddress(city).build());
    }

    private static Stream<Arguments> testThrowIllegalStateExceptionArguments() {
        return Stream.of(
                Arguments.of(null, null, 0, null),
                Arguments.of("Name", null, 0, null),
                Arguments.of("Name", null, 10, null),
                Arguments.of("Name", null, 0, "City"),
                Arguments.of("Name", null, 10, "City"),
                Arguments.of(null, "Surname", 0, null),
                Arguments.of(null, "Surname", 10, null),
                Arguments.of(null, "Surname", 0, "City"),
                Arguments.of(null, "Surname", 10, "City"),
                Arguments.of("", "Surname", 10, "City"),
                Arguments.of("Name", "", 10, "City"),
                Arguments.of("", "", 10, "City")
        );
    }

    @Test
    void testThrowIllegalArgumentException() {
        var expected = IllegalArgumentException.class;
        assertThrows(expected,
                () -> sut.setName("Name").setSurname("Surname").setAge(-100).build());
    }

    @AfterAll
    static void finish() {
        System.out.println("Finish PersonBuilder tests");
    }
}

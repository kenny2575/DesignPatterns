package adapterPattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntsCalculatorTest {
    IntsCalculator sut;
    @BeforeEach
    public void init(){
       sut = new IntsCalculator();
    }

    @ParameterizedTest
    @MethodSource
    void sumTest(int a, int b, int expected){
        assertEquals(sut.sum(a, b), expected);
    }

    static Stream<Arguments> sumTest(){
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(84, 23, 107),
                Arguments.of(74, -54, 20)
        );
    }

    @ParameterizedTest
    @MethodSource
    void multTest(int a, int b, int expected){
        assertEquals(sut.mult(a, b), expected);
    }

    static Stream<Arguments> multTest(){
        return Stream.of(
                Arguments.of(25, 25, 625),
                Arguments.of(12,12,144),
                Arguments.of(7,8,56)
        );
    }

    @ParameterizedTest
    @MethodSource
    void powTest(int a, int b, int expected){
        assertEquals(sut.pow(a, b), expected);
    }

    static Stream<Arguments> powTest(){
        return Stream.of(
                Arguments.of(13, 2, 169),
                Arguments.of(2, 11, 2048),
                Arguments.of(7,4,2401)
        );
    }

    @AfterEach
    public void finish(){
        sut = null;
    }
}

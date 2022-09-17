package facadePattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinOpsTest {
    BinOps sut;

    @BeforeEach
    void init(){
        sut = new BinOps();
    }

    @ParameterizedTest
    @MethodSource
    void sumTest(String a, String b, String expected){
        assertThat(sut.sum(a,b), equalTo(expected));
    }

    static Stream<Arguments> sumTest(){
        return Stream.of(
                Arguments.of("1", "1", "10"),
                Arguments.of("110110", "1010110", "10001100"),
                Arguments.of("101001", "1000001", "1101010")
        );
    }

    @ParameterizedTest
    @MethodSource
    void multTest(String a, String b, String expected){
        assertThat(sut.mult(a, b), equalTo(expected));
    }

    static Stream<Arguments> multTest(){
        return Stream.of(
                Arguments.of("1","1","1"),
                Arguments.of("1010100","1000","1010100000"),
                Arguments.of("101001", "1000001", "101001101001")
        );
    }
}

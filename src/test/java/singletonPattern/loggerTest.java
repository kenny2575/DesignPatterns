package singletonPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class loggerTest {
    static Logger sut;

    @BeforeEach
    void beforeEach(){
        sut = Logger.getInstance();
    }
    @Test
    void testSingleton(){
        assertTrue(sut == Logger.getInstance());
    }
}

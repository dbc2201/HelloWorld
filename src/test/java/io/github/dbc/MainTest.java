package io.github.dbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {

    private String output;

    @BeforeEach
    void setUp() {
        // initialize the system out stream to a ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // set the system out stream to the ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
        // call the main method
        Main.main(new String[]{});
        // get the output from the ByteArrayOutputStream
        output = outputStream.toString().trim();
    }

    @Test
    @DisplayName("The name of the class should be \"Main\".")
    @Order(1)
    void nameOfClassShouldBeMain() {
        // arrange
        String expectedClassName = "Main";
        // act
        String actualClassName = Main.class.getSimpleName();
        // assert
        assertEquals(expectedClassName, actualClassName, "The name of the class should be \"Main\"." +
                "Please don't change the name of the class.");
    }

    @Test
    @DisplayName("Something should be printed on the console.")
    @Order(2)
    void testSomething() {
        assertTrue(output.length() > 0, "No output was printed. Please check the code for any errors.");
    }

    @Test
    @DisplayName("H should be capital.")
    @Order(3)
    void testFirstLetterIsCapital() {
        String firstCharacterAsString = output.substring(0, 1);
        assertEquals("H", firstCharacterAsString, "The 'H' in \"Hello, World!\" should be capitalized!");
    }

    @Test
    @DisplayName("W should be capital.")
    @Order(4)
    void testOutputContainsW() {
        String wCharacterAsString = output.substring(6, 7);
        assertEquals("w", wCharacterAsString,
                "The 'W' in \"Hello, World!\" should be capitalized!");
    }

}
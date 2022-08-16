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
}
package io.github.sttanyanz.enote.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void getFile() {
        final File inputValue = File.a;
        final File expectedValue = inputValue;

        final Square square = new Square(inputValue, 1);

        final File actualValue = square.getFile();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getRank() {
        final int inputValue = 3;
        final int expectedValue = inputValue;

        final Square square = new Square(null, inputValue);

        final int actualValue = square.getRank();

        assertEquals(expectedValue, actualValue);
    }
}
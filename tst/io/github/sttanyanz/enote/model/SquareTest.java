package io.github.sttanyanz.enote.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testGetFile() {
        final int inputValue = 5;
        final int expectedValue = inputValue;

        final Square square = new Square(inputValue, 1);
        final int actualValue = square.getFile();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetRank() {
        final int inputValue = 3;
        final int expectedValue = inputValue;

        final Square square = new Square(1, inputValue);
        final int actualValue = square.getRank();

        assertEquals(expectedValue, actualValue);
    }
}
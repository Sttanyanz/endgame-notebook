package io.github.sttanyanz.enote.model;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void getName() {
        final String inputValue = "Niki";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        final Color inputValue = Color.white;
        final Color expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Color actualValue = player.getColor();

        assertEquals(expectedValue, actualValue);
    }
}
package io.github.sttanyanz.enote.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGetWhite() {
        final Player inputWhitePlayer = new Player("Emily", Color.white);
        final Player expectedWhitePlayer = inputWhitePlayer;
        final Game game = new Game(inputWhitePlayer, null, null);
        final Player actualWhitePlayer = game.getWhitePlayer();
        assertEquals(expectedWhitePlayer, actualWhitePlayer);
    }

    @Test
    void testGetBlack() {
        final Player inputBlackPlayer = new Player("Sarah", Color.white);
        final Player expectedBlackPlayer = inputBlackPlayer;
        final Game game = new Game(null, inputBlackPlayer, null);
        final Player actualBlackPlayer = game.getBlackPlayer();
        assertEquals(expectedBlackPlayer, actualBlackPlayer);
    }

    @Test
    void testGetBoard() {
        final Board inputBoard = new Board();
        final Board expectedBoard = inputBoard;
        final Game game = new Game(null, null, inputBoard);
        final Board actualBoard = game.getBoard();
        assertEquals(expectedBoard, actualBoard);
    }
}
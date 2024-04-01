package io.github.sttanyanz.enote.model;

import io.github.sttanyanz.enote.model.exceptions.InvalidSquareException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testGetSize() {
        final Board board = new Board();
        assertEquals(8, board.getSize());
    }

    @Test
    void testSetPiece() throws InvalidSquareException {
        final Board board = new Board();
        final Piece inputPiece = Piece.whiteQueen;
        final Piece expectedPiece = inputPiece;
        final Square inputSquare = new Square(6, 7);
        board.setPiece(inputSquare,inputPiece);
        final Piece actualPiece = board.getPiece(inputSquare);
        assertEquals(expectedPiece, actualPiece);
    }

    @Test
    void testMovePiece() throws InvalidSquareException {
        final Board board = new Board();
        final Piece inputPiece = Piece.whiteQueen;
        final Piece expectedPiece = inputPiece;
        final Square inputPlacement = new Square(0, 1);
        final Square inputDestination = new Square(3, 4);
        board.setPiece(inputPlacement, inputPiece);
        board.movePiece(inputPlacement, inputDestination);
        final Piece actualPiece = board.getPiece(inputDestination);
        assertEquals(expectedPiece, actualPiece);
    }

    @Test
    void testSwitchTurn() {
        final Board board = new Board();
        final Color expectedTurn = Color.black;
        board.switchTurn();
        final Color actualTurn = board.getTurn();
        assertEquals(expectedTurn, actualTurn);
    }
}
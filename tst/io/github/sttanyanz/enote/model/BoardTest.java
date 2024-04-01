package io.github.sttanyanz.enote.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getSize() {
        final Board board = new Board();
        assertEquals(8, board.getSize());
    }

    @Test
    void setPiece() {
        final Board board = new Board();
        final Piece inputPiece = Piece.whiteQueen;
        final Piece expectedPiece = inputPiece;
        final Square inputSquare = new Square(6, 7);
        board.setPiece(inputSquare,inputPiece);
        final Piece actualPiece = board.getPiece(inputSquare);
        assertEquals(expectedPiece, actualPiece);
    }

    @Test
    void movePiece() {
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
    void switchTurn() {
        final Board board = new Board();
        final Color expectedTurn = Color.black;
        board.switchTurn();
        final Color actualTurn = board.getTurn();
        assertEquals(expectedTurn, actualTurn);
    }
}
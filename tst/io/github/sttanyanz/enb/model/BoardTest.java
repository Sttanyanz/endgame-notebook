package io.github.sttanyanz.enb.model;

import io.github.sttanyanz.enb.model.exceptions.InvalidSquareException;
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

    @Test
    void testGetPieceWhenSquareIsEmpty() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputSquare = new Square(1, 1);

        final Piece actualPiece = board.getPiece(inputSquare);

        assertNull(actualPiece);
    }

    @Test
    void testGetPieceWhenFileIsLessThanZero() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputSquare = new Square(-1, 0);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenRankIsLessThanZero() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputSquare = new Square(0, -1);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenFileIsAboveSize() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputSquare = new Square(10, 0);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenRankIsAboveSize() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputSquare = new Square(0, 10);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }
}

package io.github.sttanyanz.enb.model;

import io.github.sttanyanz.enb.model.exceptions.EmptySquareException;
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
        final Piece inputPiece = new Piece(PieceName.king, Color.black);
        final Piece expectedPiece = inputPiece;
        final Square inputSquare = new Square(6, 7);

        board.setPiece(inputSquare,inputPiece);
        final Piece actualPiece = board.getPiece(inputSquare);

        assertEquals(expectedPiece, actualPiece);
    }

    @Test
    void testMovePiece() throws InvalidSquareException, EmptySquareException {
        final Board board = new Board();
        final Piece inputPiece = new Piece(PieceName.queen, Color.white);
        final Piece expectedPiece = inputPiece;
        final Square inputOriginSquare = new Square(0, 1);
        final Square inputDestinationSquare = new Square(3, 4);

        board.setPiece(inputOriginSquare, inputPiece);
        board.movePiece(inputOriginSquare, inputDestinationSquare);
        final Piece actualPiece = board.getPiece(inputDestinationSquare);

        assertEquals(expectedPiece, actualPiece);
    }

    @Test
    void testCheckIfOriginSquareIsEmptyAfterMovingPiece() throws InvalidSquareException, EmptySquareException {
        final Board board = new Board();
        final Piece inputPiece = new Piece(PieceName.bishop, Color.black);
        final Square inputOriginSquare = new Square(0, 1);
        final Square inputDestinationSquare = new Square(3, 4);

        board.setPiece(inputOriginSquare, inputPiece);
        board.movePiece(inputOriginSquare, inputDestinationSquare);
        final Piece actualOriginSquare = board.getPiece(inputOriginSquare);

        assertNull(actualOriginSquare);
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
    void testGetPieceWhenFileIsLessThanZero(){
        final Board board = new Board();
        final Square inputSquare = new Square(-1, 0);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenRankIsLessThanZero(){
        final Board board = new Board();
        final Square inputSquare = new Square(0, -1);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenFileIsAboveSize(){
        final Board board = new Board();
        final Square inputSquare = new Square(10, 0);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testGetPieceWhenRankIsAboveSize(){
        final Board board = new Board();
        final Square inputSquare = new Square(0, 10);

        try {
            board.getPiece(inputSquare);
            fail();
        } catch (final InvalidSquareException e) {}
    }

    @Test
    void testMovePieceFromEmptySquare() throws InvalidSquareException {
        final Board board = new Board();
        final Square inputOriginSquare = new Square(6, 4);
        final Square inputDestinationSquare = new Square(3, 2);

        try {
            board.movePiece(inputOriginSquare, inputDestinationSquare);
            fail();
        } catch (final EmptySquareException e) {}
    }
}

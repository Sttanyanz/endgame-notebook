package io.github.sttanyanz.enb.model;

import io.github.sttanyanz.enb.model.exceptions.EmptySquareException;
import io.github.sttanyanz.enb.model.exceptions.InvalidSquareException;

public class Board {
    private static final int BOARD_SIZE = 8;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = BOARD_SIZE;
    private Color turn = Color.white;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];


    public int getSize(){
        return Board.BOARD_SIZE;
    }

    public Piece getPiece(final Square square) throws InvalidSquareException {
        if (!checkSquareBounds(square)) {
            throw new InvalidSquareException();
        }
        return board[square.getFile()][square.getRank()];
    }

    public Color getTurn() {
        return turn;
    }

    public void setPiece(final Square square, final Piece piece) throws InvalidSquareException {
        if (!checkSquareBounds(square)) {
            throw new InvalidSquareException();
        }
        board[square.getFile()][square.getRank()] = piece;
    }

    public void movePiece(final Square originSquare, final Square destinationSquare)
            throws InvalidSquareException, EmptySquareException
    {
        if (!checkSquareBounds(originSquare) || !checkSquareBounds(destinationSquare)) {
            throw new InvalidSquareException();
        }
        if (getPiece(originSquare) == null) {
            throw new EmptySquareException();
        }
        board[destinationSquare.getFile()][destinationSquare.getRank()] =
                board[originSquare.getFile()][originSquare.getRank()];
        board[originSquare.getFile()][originSquare.getRank()] = null;
    }

    public void switchTurn () {
        if (turn == Color.white) turn = Color.black;
        else turn = Color.white;
    }

    public boolean isSquareEmpty(final Square square) throws InvalidSquareException {
        return getPiece(square) == null;
    }

    private boolean checkSquareBounds(final Square square){
        return checkIndexBounds(square.getFile()) && checkIndexBounds(square.getRank());
    }

    private boolean checkIndexBounds(final int index){
        return index >= MIN_COORDINATE && index < MAX_COORDINATE;
    }

}

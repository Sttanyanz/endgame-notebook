package io.github.sttanyanz.enb.model;

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
        if (!boundCheckSquare(square)) {
            throw new InvalidSquareException();
        }
        return board[square.getFile()][square.getRank()];
    }

    public Color getTurn() {
        return turn;
    }

    public void setPiece(final Square square, final Piece piece) throws InvalidSquareException {
        if (!boundCheckSquare(square)) {
            throw new InvalidSquareException();
        }
        board[square.getFile()][square.getRank()] = piece;
    }

    public void movePiece(final Square placement, final Square destination) throws InvalidSquareException {
        if (!boundCheckSquare(placement) || !boundCheckSquare(destination)) {
            throw new InvalidSquareException();
        }
        Piece temp = board[placement.getFile()][placement.getRank()];
        board[placement.getFile()][placement.getRank()] =
                board[destination.getFile()][destination.getRank()];
        board[destination.getFile()][destination.getRank()] = temp;
    }

    public void switchTurn () {
        if (turn == Color.white) turn = Color.black;
        else turn = Color.white;
    }

    private boolean boundCheckSquare(final Square square){
        return boundCheckIndex(square.getFile()) && boundCheckIndex(square.getRank());
    }

    private boolean boundCheckIndex(final int index){
        return index >= MIN_COORDINATE && index < MAX_COORDINATE;
    }

}

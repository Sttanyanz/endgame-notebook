package io.github.sttanyanz.enote.model;

public class Board {
    private static final int BOARD_SIZE = 8;
    private Color turn = Color.white;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public int getSize(){
        return Board.BOARD_SIZE;
    }

    public Piece getPiece(final Square square){
        return board[square.getFile().getIndex()][square.getRank()];
    }

    public Color getTurn() {
        return turn;
    }

    public void setPiece(final Square square, final Piece piece){
        board[square.getFile().getIndex()][square.getRank()] = piece;
    }

    public void movePiece(final Square placement, final Square destination){
        Piece temp = board[placement.getFile().getIndex()][placement.getRank()];
        board[placement.getFile().getIndex()][placement.getRank()] =
                board[destination.getFile().getIndex()][destination.getRank()];
        board[destination.getFile().getIndex()][destination.getRank()] = temp;
    }

    public void switchTurn () {
        if (turn == Color.white) turn = Color.black;
        else turn = Color.white;
    }

}

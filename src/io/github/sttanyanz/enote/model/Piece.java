package io.github.sttanyanz.enote.model;

public enum Piece {
    whitePawn(Color.white), blackPawn(Color.black),
    whiteKnight(Color.white), blackKnight(Color.black),
    whiteBishop(Color.white), blackBishop(Color.black),
    whiteRook(Color.white), blackRook(Color.black),
    whiteQueen(Color.white),blackQueen(Color.black);
    private final Color color;

    Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

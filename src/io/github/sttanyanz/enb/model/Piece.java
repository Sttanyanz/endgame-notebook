package io.github.sttanyanz.enb.model;

public class Piece {
    private final PieceName name;
    private final Color color;

    Piece(PieceName name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public PieceName getName() { return name; }
}

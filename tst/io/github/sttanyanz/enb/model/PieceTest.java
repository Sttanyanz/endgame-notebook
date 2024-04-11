package io.github.sttanyanz.enb.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void testGetColor() {
        final Piece inputPiece = new Piece(PieceName.pawn, Color.white);
        final Color expectedColor = Color.white;
        final Color actualColor = inputPiece.getColor();

        assertEquals(expectedColor, actualColor);
    }

    @Test
    void testGetName() {
        final Piece inputPiece = new Piece(PieceName.knight, Color.black);
        final PieceName expectedName = PieceName.knight;
        final PieceName actualName = inputPiece.getName();

        assertEquals(expectedName, actualName);
    }
}
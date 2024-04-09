package io.github.sttanyanz.enote.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    @Test
    void testgetColor() {
        final Piece inputPiece = Piece.whitePawn;
        final Color expectedColor = Color.white;
        final Color actualColor = inputPiece.getColor();

        assertEquals(expectedColor, actualColor);
    }
}
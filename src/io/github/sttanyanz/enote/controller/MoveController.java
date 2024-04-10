package io.github.sttanyanz.enote.controller;

import io.github.sttanyanz.enote.model.Board;
import io.github.sttanyanz.enote.model.Square;
import io.github.sttanyanz.enote.model.exceptions.InvalidSquareException;

public class MoveController {

    public void movePiece (Board board,
                           Square placement,
                           Square destination) throws InvalidSquareException {
        board.movePiece(placement, destination);
    }
}

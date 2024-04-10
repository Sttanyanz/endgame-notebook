package io.github.sttanyanz.enb.controller;

import io.github.sttanyanz.enb.model.Board;
import io.github.sttanyanz.enb.model.Square;
import io.github.sttanyanz.enb.model.exceptions.InvalidSquareException;

public class MoveController {

    public void movePiece (Board board,
                           Square placement,
                           Square destination) throws InvalidSquareException {
        board.movePiece(placement, destination);
    }
}

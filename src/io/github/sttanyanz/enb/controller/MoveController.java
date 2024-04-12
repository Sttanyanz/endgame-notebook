package io.github.sttanyanz.enb.controller;

import io.github.sttanyanz.enb.model.Board;
import io.github.sttanyanz.enb.model.Color;
import io.github.sttanyanz.enb.model.Square;
import io.github.sttanyanz.enb.model.exceptions.IllegalMoveException;
import io.github.sttanyanz.enb.model.exceptions.InvalidSquareException;

import javax.swing.text.PlainDocument;

import static java.lang.Math.*;

public class MoveController {

    public void movePiece (Board board,
                           Square placement,
                           Square destination) throws InvalidSquareException, IllegalMoveException {
        switch (board.getPiece(placement).getName()) {
            case pawn -> {
                if (!isPawnMoveLegal(board, placement, destination)) {
                        throw new IllegalMoveException();
                }
            }
            case knight -> {
                if (!isKnightMoveLegal(board, placement, destination)) {
                    throw new IllegalMoveException();
                }
            }
            case bishop -> {
                if (!isBishopMoveLegal(board, placement, destination)) {
                    throw new IllegalMoveException();
                }
            }
            case rook -> {
                if (!isRookMoveLegal(board, placement, destination)) {
                    throw new IllegalMoveException();
                }
            }
            case queen -> {
                if (!isQueenMoveLegal(board, placement, destination)) {
                    throw new IllegalMoveException();
                }
            }
            case king -> {
                if (!isKingMoveLegal(board, placement, destination)) {
                    throw new IllegalMoveException();
                }
            }
        }
        board.movePiece(placement, destination);
    }

    private boolean isKingMoveLegal(final Board board,
                                    final Square placement,
                                    final Square destination){
        return areSquaresAdjacent(placement, destination);
    }

    private boolean isQueenMoveLegal(final Board board,
                                     final Square placement,
                                     final Square destination){
        return areSquaresOnSameFile(placement, destination)
                || areSquaresOnSameRank(placement, destination)
                || areSquaresOnSameDiagonal(placement, destination);
    }

    private boolean isRookMoveLegal(final Board board,
                                    final Square placement,
                                    final Square destination){
        return areSquaresOnSameFile(placement, destination)
                || areSquaresOnSameRank(placement, destination);
    }

    private boolean isBishopMoveLegal(final Board board,
                                      final Square placement,
                                      final Square destination){
        return areSquaresOnSameDiagonal(placement, destination);
    }

    private boolean isKnightMoveLegal(final Board board,
                                      final Square placement,
                                      final Square destination){
        return areSquaresWithinKnightReach(placement, destination);
    }

    private boolean isPawnMoveLegal(final Board board,
                                    final Square placement,
                                    final Square destination)
            throws InvalidSquareException
    {
        return isDestinationInFrontOfPiece
                (board.getPiece(placement).getColor(), placement, destination);

    }

    private boolean areSquaresAdjacent(final Square squareOne,
                                       final Square squareTwo){
        return (abs(squareOne.getRank() - squareTwo.getRank()) <= 1)
                && (abs(squareOne.getFile() - squareTwo.getFile()) <= 1);
    }

    private boolean areSquaresOnSameRank(final Square squareOne,
                                         final Square squareTwo){
        return squareOne.getRank() == squareTwo.getRank();
    }

    private boolean areSquaresOnSameFile(final Square squareOne,
                                         final Square squareTwo){
        return squareOne.getFile() == squareTwo.getFile();
    }

    private boolean areSquaresOnSameDiagonal(final Square squareOne,
                                             final Square squareTwo){
        return abs(squareOne.getFile() - squareTwo.getFile())
                == abs(squareOne.getRank() - squareTwo.getRank());
    }

    private boolean areSquaresWithinKnightReach(final Square squareOne,
                                                final Square squareTwo){
        final int fileDisplacement = abs(squareOne.getFile() - squareTwo.getFile());
        final int rankDisplacement = abs(squareOne.getRank() - squareTwo.getRank());

        return min(fileDisplacement, rankDisplacement) == 1
                && max(fileDisplacement, rankDisplacement) == 2;
    }

    private boolean isDestinationInFrontOfPiece(final Color color,
                                  final Square placement,
                                  final Square destination){
        if (!areSquaresOnSameFile(placement, destination))
            return false;
        if (color == Color.white)
            return placement.getRank() + 1 == destination.getRank();
        else if (color == Color.black)
            return placement.getRank() -1 == destination.getRank();
        else
            return false;
    }

}

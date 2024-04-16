package io.github.sttanyanz.enb.controller;

import io.github.sttanyanz.enb.model.Board;
import io.github.sttanyanz.enb.model.Color;
import io.github.sttanyanz.enb.model.Square;
import io.github.sttanyanz.enb.model.exceptions.EmptySquareException;
import io.github.sttanyanz.enb.model.exceptions.UnreachableSquareForPieceNameException;
import io.github.sttanyanz.enb.model.exceptions.InvalidSquareException;

import static java.lang.Math.*;

public class MoveController {

    public void movePiece (Board board,
                           Square originSquare,
                           Square destinationSquare)
            throws InvalidSquareException,
            UnreachableSquareForPieceNameException,
            EmptySquareException
    {
        switch (board.getPiece(originSquare).getName()) {
            case pawn -> {
                if (!isPawnMoveLegal(board, originSquare, destinationSquare)) {
                        throw new UnreachableSquareForPieceNameException();
                }
            }
            case knight -> {
                if (!isKnightMoveLegal(board, originSquare, destinationSquare)) {
                    throw new UnreachableSquareForPieceNameException();
                }
            }
            case bishop -> {
                if (!isBishopMoveLegal(board, originSquare, destinationSquare)) {
                    throw new UnreachableSquareForPieceNameException();
                }
            }
            case rook -> {
                if (!isRookMoveLegal(board, originSquare, destinationSquare)) {
                    throw new UnreachableSquareForPieceNameException();
                }
            }
            case queen -> {
                if (!isQueenMoveLegal(board, originSquare, destinationSquare)) {
                    throw new UnreachableSquareForPieceNameException();
                }
            }
            case king -> {
                if (!isKingMoveLegal(board, originSquare, destinationSquare)) {
                    throw new UnreachableSquareForPieceNameException();
                }
            }
        }
        board.movePiece(originSquare, destinationSquare);
    }

    private boolean isKingMoveLegal(final Board board,
                                    final Square originSquare,
                                    final Square destinationSquare){
        return areSquaresAdjacent(originSquare, destinationSquare);
    }

    private boolean isQueenMoveLegal(final Board board,
                                     final Square originSquare,
                                     final Square destinationSquare){
        return areSquaresOnSameFile(originSquare, destinationSquare)
                || areSquaresOnSameRank(originSquare, destinationSquare)
                || areSquaresOnSameDiagonal(originSquare, destinationSquare);
    }

    private boolean isRookMoveLegal(final Board board,
                                    final Square originSquare,
                                    final Square destinationSquare){
        return areSquaresOnSameFile(originSquare, destinationSquare)
                || areSquaresOnSameRank(originSquare, destinationSquare);
    }

    private boolean isBishopMoveLegal(final Board board,
                                      final Square originSquare,
                                      final Square destinationSquare){
        return areSquaresOnSameDiagonal(originSquare, destinationSquare);
    }

    private boolean isKnightMoveLegal(final Board board,
                                      final Square originSquare,
                                      final Square destinationSquare){
        return areSquaresWithinKnightReach(originSquare, destinationSquare);
    }

    private boolean isPawnMoveLegal(final Board board,
                                    final Square originSquare,
                                    final Square destinationSquare)
            throws InvalidSquareException
    {
        return isDestinationSquareInFrontOfPiece
                (board.getPiece(originSquare).getColor(), originSquare, destinationSquare);

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

    private boolean isDestinationSquareInFrontOfPiece(final Color color,
                                  final Square originSquare,
                                  final Square destinationSquare){
        if (!areSquaresOnSameFile(originSquare, destinationSquare))
            return false;
        if (color == Color.white)
            return originSquare.getRank() + 1 == destinationSquare.getRank();
        else if (color == Color.black)
            return originSquare.getRank() -1 == destinationSquare.getRank();
        else
            return false;
    }

}

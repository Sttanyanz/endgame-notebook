package io.github.sttanyanz.enb.model;

public class Square {
    private final int file;
    private final int rank;


    public Square(int file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }
}

package io.github.sttanyanz.enote.model;

public class Square {
    private final File file;
    private final int rank;


    public Square(File file, int rank) {
        this.file = file;
        this.rank = rank - 1;
    }

    public File getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }
}

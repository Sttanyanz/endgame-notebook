package io.github.sttanyanz.enote.model;

public enum File {
    a((byte) 0), b((byte) 1), c((byte) 2), d((byte) 3),
    e((byte) 4), f((byte) 5), g((byte) 6), h((byte) 7);

    private final byte index;

    File(byte index) {
        this.index = index;
    }

    public byte getIndex() {
        return index;
    }
}
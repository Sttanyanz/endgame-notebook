package io.github.sttanyanz.enote.model;

public enum File {
    a((byte) 1), b((byte) 2), c((byte) 3), d((byte) 4),
    e((byte) 5), f((byte) 6), g((byte) 7), h((byte) 8);

    private final byte index;

    File(byte index) {
        this.index = index;
    }

    public byte getIndex() {
        return index;
    }
}
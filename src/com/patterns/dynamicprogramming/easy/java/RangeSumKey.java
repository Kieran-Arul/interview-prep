package com.patterns.dynamicprogramming.easy.java;

public class RangeSumKey {

    private final int start;
    private final int end;

    public RangeSumKey(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RangeSumKey that = (RangeSumKey) o;

        if (this.start != that.start) {
            return false;
        }

        return this.end == that.end;
    }

    @Override
    public int hashCode() {
        return (31 * this.start) + this.end;
    }

}

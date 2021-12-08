package com.patterns.dynamicprogramming.medium.java;

public class LcsCacheKey {

    private final int s1Length;
    private final int s2Length;

    public LcsCacheKey(int s1Length, int s2Length) {
        this.s1Length = s1Length;
        this.s2Length = s2Length;
    }

    public int getS1Length() {
        return this.s1Length;
    }

    public int getS2Length() {
        return this.s2Length;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LcsCacheKey that = (LcsCacheKey) o;

        if (this.s1Length != that.s1Length) {
            return false;
        }

        return this.s2Length == that.s2Length;
    }

    @Override
    public int hashCode() {
        return (31 * this.s1Length) + this.s2Length;
    }

}

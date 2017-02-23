package com.debapriyo.spaceinvaders.domain;

/**
 * Domain representing a coordinate in any {@link Image}.
 * 
 * @author Debapriyo Majumder
 * @version 1.0
 * @since 2/22/2017
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Constructor.
     * 
     * @param x the x coordinate of the {@link Image}
     * @param y the y coordinate of the {@link Image}
     */
    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x coordinate of the {@link Image}
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x coordinate of the {@link Image} to set
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @return the y coordinate of the {@link Image}
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y coordinate of the {@link Image} to set
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}

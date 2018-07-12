package com.banckom.game.model;

/**
 * A position (x,y) on the playing area
 *
 * @author a-yarmakovich
 */
public class Position {
    private double x;
    private double y;
    private long timestamp;

    /**
     * Constructs a new position
     * @param x an x value
     * @param y an y value
     * @param timestamp a timestamp
     */
    public Position(double x, double y, long timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    /**
     * Gets the x value
     * @return the x value
     */
    public double getX() {
        return x;
    }

    /**
     * Sets an x value
     * @param x a new x value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y value
     * @return the y value
     */
    public double getY() {
        return y;
    }

    /**
     * Sets an y value
     * @param y a new x value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the timestamp
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets a timestamp
     * @param timestamp a new timestamp
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

package com.banckom.game.model;

/**
 * A player in the game
 *
 * @author a-yarmakovich
 */
public class Player {
    private Position position;
    private PlayingArea playingArea;
    private int yellowCardsCount;
    private int ejectingCount;
    private long lastEjectingTimestamp;
    private boolean ejected;

    /**
     * Gets the position
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets a position
     * @param position a new position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets the playing area
     * @return the playing area
     */
    public PlayingArea getPlayingArea() {
        return playingArea;
    }

    /**
     * Sets a playing area
     * @param playingArea a new playing area
     */
    public void setPlayingArea(PlayingArea playingArea) {
        this.playingArea = playingArea;
    }

    /**
     * Gets the yellow cards count
     * @return the yellow cards count
     */
    public int getYellowCardsCount() {
        return yellowCardsCount;
    }

    /**
     * Sets a yellow cards count
     * @param yellowCardsCount a yellow cards count
     */
    public void setYellowCardsCount(int yellowCardsCount) {
        this.yellowCardsCount = yellowCardsCount;
    }

    /**
     * Gets the ejecting count
     * @return the ejecting count
     */
    public int getEjectingCount() {
        return ejectingCount;
    }

    /**
     * Sets an ejecting count
     * @param ejectingCount a new ejecting count
     */
    public void setEjectingCount(int ejectingCount) {
        this.ejectingCount = ejectingCount;
    }

    /**
     * Gets the last ejecting timestamp
     * @return the last ejecting timestamp
     */
    public long getLastEjectingTimestamp() {
        return lastEjectingTimestamp;
    }

    /**
     * Sets a last ejecting timestamp
     * @param lastEjectingTimestamp a new last ejecting timestamp
     */
    public void setLastEjectingTimestamp(long lastEjectingTimestamp) {
        this.lastEjectingTimestamp = lastEjectingTimestamp;
    }

    /**
     * Gets the flag if ejected
     * @return the ejecting count
     */
    public boolean isEjected() {
        return ejected;
    }

    /**
     * Sets a flag if ejected
     * @param ejected a new flag if ejected
     */
    public void setEjected(boolean ejected) {
        this.ejected = ejected;
    }
}

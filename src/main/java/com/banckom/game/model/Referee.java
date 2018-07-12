package com.banckom.game.model;

/**
 * A referee in the game
 *
 * @author a-yarmakovich
 */
public class Referee {
    private PlayingArea playingArea;

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
}

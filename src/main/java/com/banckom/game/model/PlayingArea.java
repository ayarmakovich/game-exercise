package com.banckom.game.model;

import java.util.List;

/**
 * A playing area of the game
 *
 * @author a-yarmakovich
 */
public class PlayingArea {
    private double length;
    private double width;
    private List<Player> players;
    private Referee referee;

    /**
     * Constructs a new playing area
     * @param length a length
     * @param width a width
     * @param players a list of players
     * @param referee a referee
     */
    public PlayingArea(double length, double width, List<Player> players, Referee referee) {
        this.length = length;
        this.width = width;
        for (Player player : players) {
            player.setPlayingArea(this);
        }
        referee.setPlayingArea(this);
        this.players = players;
        this.referee = referee;
    }

    /**
     * Gets the length
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets a length
     * @param length a new length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the width
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets a width
     * @param width a new width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Gets the list of players
     * @return the list of players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Sets a list of players
     * @param players a new list of players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Gets the referee
     * @return the referee
     */
    public Referee getReferee() {
        return referee;
    }

    /**
     * Sets a referee
     * @param referee a new referee
     */
    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}

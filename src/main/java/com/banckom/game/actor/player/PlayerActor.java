package com.banckom.game.actor.player;

/**
 * An actor of a player in the game
 *
 * @author a-yarmakovich
 */
public interface PlayerActor {
    /**
     * Takes a random position on the playing area (if not taken yet)
     */
    void startOut();

    /**
     * Moves 1m from the current position if possible
     * @param xShift a shift in horizontal direction
     * @param yUp a flag if move up or down in vertical direction
     * @return true if moved; false otherwise
     */
    boolean move(double xShift, boolean yUp);

    /**
     * Asks referee for permission to play again (after an ejecting)
     */
    void askForPermissionToPlay();
}

package com.banckom.game.actor.referee;

/**
 * An actor of a referee in the game
 *
 * @author a-yarmakovich
 */
public interface RefereeActor {
    /**
     * Inspects the positions of the player on the playing area.
     * Gives them yellow card for not allowed positions
     */
    void inspectPlayersPositions();
}

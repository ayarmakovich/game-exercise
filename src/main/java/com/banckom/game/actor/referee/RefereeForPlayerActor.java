package com.banckom.game.actor.referee;

import com.banckom.game.model.Player;

/**
 * An actor of a referee for players to ask something during the game
 *
 * @author a-yarmakovich
 */
public interface RefereeForPlayerActor {
    /**
     * Checks if a player can play again and allows him to play if yes
     * @param player a player
     * @return true if the player can play; false otherwise
     */
    boolean allowToPlay(Player player);
}

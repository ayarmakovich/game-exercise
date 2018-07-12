package com.banckom.game.actor.referee;

import com.banckom.game.model.Player;

import java.util.Date;

public class RefereeForPlayerActorImpl implements RefereeForPlayerActor {
    @Override
    public boolean allowToPlay(Player player) {
        if (!player.isEjected()) {
            return true;
        }
        if (player.getEjectingCount() >= 2) {
            return false;
        }
        if (nowTimestamp() - player.getLastEjectingTimestamp() >= 10 * 1000) {
            player.setEjected(false);
            return true;
        }
        return false;
    }

    private long nowTimestamp() {
        return new Date().getTime();
    }
}

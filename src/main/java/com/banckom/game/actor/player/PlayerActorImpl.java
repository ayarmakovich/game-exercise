package com.banckom.game.actor.player;

import com.banckom.game.actor.referee.RefereeForPlayerActor;
import com.banckom.game.actor.referee.RefereeForPlayerActorImpl;
import com.banckom.game.model.Player;
import com.banckom.game.model.Position;

import java.util.Date;

import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class PlayerActorImpl implements PlayerActor {
    private Player player;
    private RefereeForPlayerActor refereeActor = new RefereeForPlayerActorImpl();

    /**
     * Constructs a new actor of a player
     * @param player a player
     */
    public PlayerActorImpl(Player player) {
        this.player = player;
    }

    @Override
    public void startOut() {
        if (player.getPosition() != null) {
            return;
        }
        double length = player.getPlayingArea().getLength();
        double width = player.getPlayingArea().getWidth();
        player.setPosition(new Position(length * random(), width * random(), nowTimestamp()));
    }

    @Override
    public boolean move(double xShift, boolean yUp) {
        if (!canBeMovedByX(xShift)) {
            return false;
        }
        double yShift = getAbsYShift(xShift);
        if (!yUp) {
            yShift *= -1;
        }
        if (canBeMovedByY(yShift)) {
            double x = player.getPosition().getX();
            double y = player.getPosition().getY();
            synchronized (player.getPlayingArea()) {
                player.setPosition(new Position(x + xShift, y + yShift, nowTimestamp()));
                return true;
            }
        }
        return false;
    }

    @Override
    public void askForPermissionToPlay() {
        refereeActor.allowToPlay(player);
    }

    private long nowTimestamp() {
        return new Date().getTime();
    }

    private boolean canBeMovedByX(double xShift) {
        double x = player.getPosition().getX();
        double length = player.getPlayingArea().getLength();
        if (Math.abs(xShift) > 1 || x + xShift < 0 || x + xShift > length) {
            return false;
        }
        return true;
    }

    private boolean canBeMovedByY(double yShift) {
        double y = player.getPosition().getY();
        double width = player.getPlayingArea().getWidth();
        if (y + yShift < 0 || y + yShift > width) {
            return false;
        }
        return true;
    }

    private double getAbsYShift(double xShift) {
        return sqrt(1 - pow(xShift, 2));
    }
}

package com.banckom.game.actor.referee;

import com.banckom.game.model.Player;
import com.banckom.game.model.Position;
import com.banckom.game.model.Referee;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class RefereeActorImpl implements RefereeActor {
    private Referee referee;

    /**
     * Constructs a new actor of a referee
     * @param referee a referee
     */
    public RefereeActorImpl(Referee referee) {
        this.referee = referee;
    }

    @Override
    public void inspectPlayersPositions() {
        synchronized (referee.getPlayingArea()) {
            List<Player> playingPlayers =
                    referee.getPlayingArea().getPlayers().stream().filter(
                            player -> !player.isEjected()).collect(Collectors.toList());
            for (int i = 0; i < playingPlayers.size(); i++) {
                for (int j = i + 1; j < playingPlayers.size(); j++) {
                    inspectPlayersPositions(playingPlayers.get(i), playingPlayers.get(j));
                }
            }
        }
    }

    private void inspectPlayersPositions(Player player1, Player player2) {
        double distance = getDistance(player1.getPosition(), player2.getPosition());
        if (distance >= 2) {
            Player playerForCard;
            if (player1.getPosition().getTimestamp() > player2.getPosition().getTimestamp()) {
                playerForCard = player1;
            } else {
                playerForCard = player2;
            }
            int yellowCardsCount = playerForCard.getYellowCardsCount() + 1;
            if (yellowCardsCount == 2) {
                playerForCard.setYellowCardsCount(0);
                int ejectingCount = playerForCard.getEjectingCount() + 1;
                playerForCard.setEjectingCount(ejectingCount);
                playerForCard.setLastEjectingTimestamp(nowTimestamp());
                playerForCard.setEjected(true);
            } else {
                playerForCard.setYellowCardsCount(yellowCardsCount);
            }
        }
    }

    private double getDistance(Position p1, Position p2) {
        return sqrt(pow(p1.getX() - p2.getX(), 2) + pow(p1.getY() - p2.getY(), 2));
    }

    private long nowTimestamp() {
        return new Date().getTime();
    }
}

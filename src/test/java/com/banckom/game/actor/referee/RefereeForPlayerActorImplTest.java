package com.banckom.game.actor.referee;

import com.banckom.game.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RefereeForPlayerActorImplTest {
    private Player player = new Player();
    private RefereeForPlayerActor refereeForPlayerActor = new RefereeForPlayerActorImpl();

    @Before
    public void setUp() throws Exception {
        player.setEjected(true);
        player.setEjectingCount(1);
        player.setLastEjectingTimestamp(nowTimestamp() - 11 * 1000);
    }

    @Test
    public void allowToPlay_should_return_true_when_player_is_not_ejected() {
        player.setEjected(false);
        boolean actual = refereeForPlayerActor.allowToPlay(player);
        assertThat(actual, is(true));
    }

    @Test
    public void allowToPlay_should_return_false_when_player_was_ejected_two_times() {
        player.setEjectingCount(2);
        boolean actual = refereeForPlayerActor.allowToPlay(player);
        assertThat(actual, is(false));
    }

    @Test
    public void allowToPlay_should_return_false_when_player_was_ejected_less_than_ten_secs_ago() {
        player.setLastEjectingTimestamp(nowTimestamp());
        boolean actual = refereeForPlayerActor.allowToPlay(player);
        assertThat(actual, is(false));
    }

    @Test
    public void allowToPlay_should_allow_and_return_true() {
        boolean actual = refereeForPlayerActor.allowToPlay(player);
        boolean ejected = player.isEjected();
        assertThat(ejected, is(false));
        assertThat(actual, is(true));
    }

    private long nowTimestamp() {
        return new Date().getTime();
    }
}

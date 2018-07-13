package com.banckom.game.actor.player;

import com.banckom.game.model.Player;
import com.banckom.game.model.PlayingArea;
import com.banckom.game.model.Position;
import com.banckom.game.model.Referee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlayerActorImplTest {
    private Position position;
    private Player player;
    private PlayingArea playingArea;
    private PlayerActor playerActor;

    @Before
    public void setUp() throws Exception {
        position = new Position(50, 40, nowTimestamp());
        player = new Player();
        player.setPosition(position);
        playingArea = new PlayingArea(100, 80, Arrays.asList(player), new Referee());
        playerActor = new PlayerActorImpl(player);
    }

    @Test
    public void startOut_should_not_set_new_position_when_it_is_not_null() {
        Position expected = player.getPosition();
        playerActor.startOut();
        Position actual = player.getPosition();
        assertThat(actual, sameInstance(expected));
    }

    @Test
    public void startOut_should_set_new_position_when_it_is_null() {
        player.setPosition(null);
        playerActor.startOut();
        Position actual = player.getPosition();
        assertThat(actual, notNullValue());
        assertTrue(actual.getX() >= 0);
        assertTrue(actual.getX() <= playingArea.getLength());
        assertTrue(actual.getY() >= 0);
        assertTrue(actual.getY() <= playingArea.getWidth());
    }

    @Test
    public void move_should_return_false_when_shift_is_greater_than_one() {
        boolean actual = playerActor.move(1.5, true);
        assertThat(actual, is(false));
    }

    @Test
    public void move_should_return_false_when_right_shift_is_too_large() {
        position.setX(0.5);
        boolean actual = playerActor.move(-0.8, true);
        assertThat(actual, is(false));
    }

    @Test
    public void move_should_return_false_when_left_shift_is_too_large() {
        position.setX(99.5);
        boolean actual = playerActor.move(0.8, true);
        assertThat(actual, is(false));
    }

    @Test
    public void move_should_return_false_when_down_shift_is_too_large() {
        position.setY(0.3);
        boolean actual = playerActor.move(0.8, false);
        assertThat(actual, is(false));
    }

    @Test
    public void move_should_return_false_when_up_shift_is_too_large() {
        position.setY(79.7);
        boolean actual = playerActor.move(0.8, true);
        assertThat(actual, is(false));
    }

    @Test
    public void move_should_return_true_and_update_position() {
        double xShift = -0.8;
        double expectedX = position.getX() + xShift;
        double expectedY = position.getY() + (-1) * sqrt(1 - pow(xShift, 2));

        boolean actual = playerActor.move(xShift, false);
        double actualX = player.getPosition().getX();
        double actualY = player.getPosition().getY();

        assertThat(actual, is(true));
        assertThat(actualX, is(expectedX));
        assertThat(actualY, is(expectedY));
    }

    private long nowTimestamp() {
        return new Date().getTime();
    }
}

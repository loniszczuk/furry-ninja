package ar.com.fn.match;

import ar.com.fn.kicker.Kick;
import ar.com.fn.kicker.Kicker;
import ar.com.fn.kicker.SimpleKicker;
import static ar.com.fn.penalty.Position.*;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class KickerTest {

    @Test
    public void test() {
        Kicker k = new SimpleKicker("jose", 1, LEFT, CENTER, RIGHT, CENTER, CENTER);

        Kick k1 = k.kick();
        Kick k2 = k.kick();
        Kick k3 = k.kick();
        Kick k4 = k.kick();
        Kick k5 = k.kick();


        assertEquals(k1.getGoalProbability(), 1.f);
        assertEquals(k1.getPosition(), LEFT);

        assertEquals(k2.getGoalProbability(), 1.f);
        assertEquals(k2.getPosition(), CENTER);

        assertEquals(k3.getGoalProbability(), 1.f);
        assertEquals(k3.getPosition(), RIGHT);

        assertEquals(k4.getGoalProbability(), 1.f);
        assertEquals(k4.getPosition(), CENTER);

        assertEquals(k5.getGoalProbability(), 1.f);
        assertEquals(k5.getPosition(), CENTER);

    }
}

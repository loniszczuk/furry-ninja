package ar.com.fn.match;

import ar.com.fn.match.kicker.Kick;
import ar.com.fn.match.kicker.Kicker;
import ar.com.fn.match.kicker.SimpleKicker;
import static ar.com.fn.match.Position.*;
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


        assert k1.getGoalProbability() == 1.f;
        assert k1.getPosition() == LEFT;

        assert k2.getGoalProbability() == 1.f;
        assert k2.getPosition() == CENTER;

        assert k3.getGoalProbability() == 1.f;
        assert k3.getPosition() == RIGHT;

        assert k4.getGoalProbability() == 1.f;
        assert k4.getPosition() == CENTER;

        assert k5.getGoalProbability() == 1.f;
        assert k5.getPosition() == CENTER;

    }
}

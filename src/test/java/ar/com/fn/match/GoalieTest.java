package ar.com.fn.match;

import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.goalie.Goalie;
import ar.com.fn.match.goalie.SimpleGoalie;
import ar.com.fn.match.kicker.Kick;
import ar.com.fn.match.kicker.Kicker;
import ar.com.fn.match.kicker.SimpleKicker;
import org.testng.annotations.Test;

import static ar.com.fn.match.Position.CENTER;
import static ar.com.fn.match.Position.LEFT;
import static ar.com.fn.match.Position.RIGHT;

public class GoalieTest {

    @Test
    public void test() {
        Goalie g = new SimpleGoalie(1, 1, LEFT, CENTER, RIGHT, CENTER, CENTER);

        Dive d1 = g.dive();
        Dive d2 = g.dive();
        Dive d3 = g.dive();
        Dive d4 = g.dive();
        Dive d5 = g.dive();


        assert d1.getPower() == 1;
        assert d1.getPrecision() == 1.f;
        assert d1.getPosition() == LEFT;

        assert d2.getPower() == 1;
        assert d2.getPrecision() == 1.f;
        assert d2.getPosition() == CENTER;

        assert d3.getPower() == 1;
        assert d3.getPrecision() == 1.f;
        assert d3.getPosition() == RIGHT;

        assert d4.getPower() == 1;
        assert d4.getPrecision() == 1.f;
        assert d4.getPosition() == CENTER;

        assert d5.getPower() == 1;
        assert d5.getPrecision() == 1.f;
        assert d5.getPosition() == CENTER;

    }

}

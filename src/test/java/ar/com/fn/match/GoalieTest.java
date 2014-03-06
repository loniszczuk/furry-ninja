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
        Goalie g = new SimpleGoalie("Jose", 1.f, LEFT, CENTER, RIGHT, CENTER, CENTER);

        Dive d1 = g.dive();
        Dive d2 = g.dive();
        Dive d3 = g.dive();
        Dive d4 = g.dive();
        Dive d5 = g.dive();


        assert d1.getBlockProbability(LEFT) == 1.f;
        assert d1.getDominantPosition().equals(LEFT);

        assert d2.getBlockProbability(CENTER) == 1.f;
        assert d2.getDominantPosition() == CENTER;

        assert d3.getBlockProbability(RIGHT) == 1.f;
        assert d3.getDominantPosition() == RIGHT;

        assert d4.getBlockProbability(CENTER) == 1.f;
        assert d4.getDominantPosition() == CENTER;

        assert d5.getBlockProbability(CENTER) == 1.f;
        assert d5.getDominantPosition() == CENTER;


    }

}

package ar.com.fn.match;

import ar.com.fn.goalie.Dive;
import ar.com.fn.goalie.Goalie;
import ar.com.fn.goalie.SimpleGoalie;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static ar.com.fn.penalty.Position.CENTER;
import static ar.com.fn.penalty.Position.LEFT;
import static ar.com.fn.penalty.Position.RIGHT;


public class GoalieTest {

    @Test
    public void test() {
        Goalie g = new SimpleGoalie("Jose", 1.f, LEFT, CENTER, RIGHT, CENTER, CENTER);

        Dive d1 = g.dive();
        Dive d2 = g.dive();
        Dive d3 = g.dive();
        Dive d4 = g.dive();
        Dive d5 = g.dive();


        assertEquals(d1.getBlockProbability(LEFT), 1.f);
        assertEquals(d1.getDominantPosition(), LEFT);

        assertEquals(d2.getBlockProbability(CENTER), 1.f);
        assertEquals(d2.getDominantPosition(), CENTER);

        assertEquals(d3.getBlockProbability(RIGHT), 1.f);
        assertEquals(d3.getDominantPosition(), RIGHT);

        assertEquals(d4.getBlockProbability(CENTER), 1.f);
        assertEquals(d4.getDominantPosition(), CENTER);

        assertEquals(d5.getBlockProbability(CENTER), 1.f);
        assertEquals(d5.getDominantPosition(), CENTER);


    }

}

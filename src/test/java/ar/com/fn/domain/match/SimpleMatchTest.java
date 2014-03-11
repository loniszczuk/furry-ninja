package ar.com.fn.domain.match;

import ar.com.fn.domain.goalie.SimpleGoalie;
import ar.com.fn.domain.kicker.SimpleKicker;
import ar.com.fn.domain.penalty.Position;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SimpleMatchTest {

    @Test
    public void test() {

        Team t1 = new Team("team1");
        t1.addKicker(new SimpleKicker("jose", 0, Position.CENTER));
        t1.addKicker(new SimpleKicker("jose", 0, Position.CENTER));
        t1.addKicker(new SimpleKicker("jose", 0, Position.CENTER));
        t1.addKicker(new SimpleKicker("jose", 0, Position.CENTER));
        t1.addKicker(new SimpleKicker("jose", 0, Position.CENTER));


        Team t2 = new Team("team2");
        t2.addGoalie(new SimpleGoalie("jose", 1, Position.CENTER));
        t2.addGoalie(new SimpleGoalie("jose", 1, Position.CENTER));
        t2.addGoalie(new SimpleGoalie("jose", 1, Position.CENTER));
        t2.addGoalie(new SimpleGoalie("jose", 1, Position.CENTER));
        t2.addGoalie(new SimpleGoalie("jose", 1, Position.CENTER));


        SimpleMatch m = new SimpleMatch(t1, t2);

        State s = m.getCurrentState();

        assertTrue(s.isFinished());
        assertEquals(s.getWinner(), t2.getName());
    }


    @Test
    public void test2() {

        Team t1 = new Team("team1");
        t1.addKicker(new SimpleKicker("pepe", 1, Position.CENTER));
        t1.addKicker(new SimpleKicker("pepe", 1, Position.CENTER));
        t1.addKicker(new SimpleKicker("pepe", 1, Position.CENTER));
        t1.addKicker(new SimpleKicker("pepe", 1, Position.CENTER));
        t1.addKicker(new SimpleKicker("pepe", 1, Position.CENTER));


        Team t2 = new Team("team2");
        t2.addGoalie(new SimpleGoalie("jose", 0.001f, Position.LEFT));
        t2.addGoalie(new SimpleGoalie("jose", 0.001f, Position.LEFT));
        t2.addGoalie(new SimpleGoalie("jose", 0.001f, Position.LEFT));
        t2.addGoalie(new SimpleGoalie("jose", 0.001f, Position.LEFT));
        t2.addGoalie(new SimpleGoalie("jose", 0.001f, Position.LEFT));


        SimpleMatch m = new SimpleMatch(t1, t2);

        State s = m.getCurrentState();

        assertTrue(s.isFinished());
        assertEquals(s.getWinner(), t1.getName());
    }

}
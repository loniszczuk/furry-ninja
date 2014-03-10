package ar.com.fn.match;

import ar.com.fn.goalie.Goalie;
import ar.com.fn.goalie.SimpleGoalie;
import ar.com.fn.kicker.Kicker;
import ar.com.fn.kicker.SimpleKicker;
import ar.com.fn.penalty.Position;
import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.assertEquals;

/**
 * Created by leandro on 5/3/14.
 */
public class TeamTest {

    @Test
    public void testKickers() {

        Team t = new Team("Team 1");
        t.addKicker(new SimpleKicker("pepe1", 1, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe2", 1, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe3", 1, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe4", 1, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe5", 1, Position.CENTER));

        Iterator<Kicker> it = t.kickers().iterator();

        assertEquals(t.getName(), "Team 1");

        assertEquals(it.next().getName(), "pepe1");
        assertEquals(it.next().getName(), "pepe2");
        assertEquals(it.next().getName(), "pepe3");
        assertEquals(it.next().getName(), "pepe4");
        assertEquals(it.next().getName(), "pepe5");
    }

    @Test
    public void testGoalies() {

        Team t = new Team("Team 2");
        t.addGoalie(new SimpleGoalie("jose1", 1, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose2",1, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose3",1, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose4",1, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose5",1, Position.CENTER));
        Iterator<Goalie> it = t.goalies().iterator();

        assertEquals(t.getName(), "Team 2");

        assertEquals(it.next().getName(), "jose1");
        assertEquals(it.next().getName(), "jose2");
        assertEquals(it.next().getName(), "jose3");
        assertEquals(it.next().getName(), "jose4");
        assertEquals(it.next().getName(), "jose5");
    }

}

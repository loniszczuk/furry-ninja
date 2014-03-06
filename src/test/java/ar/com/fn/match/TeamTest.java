package ar.com.fn.match;

import ar.com.fn.match.goalie.Goalie;
import ar.com.fn.match.goalie.SimpleGoalie;
import ar.com.fn.match.kicker.Kicker;
import ar.com.fn.match.kicker.SimpleKicker;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * Created by leandro on 5/3/14.
 */
public class TeamTest {

    @Test
    public void testKickers() {

        Team t = new Team("Team 1");
        t.addKicker(new SimpleKicker("pepe1", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe2", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe3", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe4", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker("pepe5", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));

        Iterator<Kicker> it = t.kickers().iterator();

        assert t.getName().equals("Team 1");

        assert "pepe1".equals(it.next().getName());
        assert "pepe2".equals(it.next().getName());
        assert "pepe3".equals(it.next().getName());
        assert "pepe4".equals(it.next().getName());
        assert "pepe5".equals(it.next().getName());
    }

    @Test
    public void testGoalies() {

        Team t = new Team("Team 2");
        t.addGoalie(new SimpleGoalie("jose1", 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose2",1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose3",1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose4",1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie("jose5",1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        Iterator<Goalie> it = t.goalies().iterator();

        assert t.getName().equals("Team 2");

        assert "jose1".equals(it.next().getName());
        assert "jose2".equals(it.next().getName());
        assert "jose3".equals(it.next().getName());
        assert "jose4".equals(it.next().getName());
        assert "jose5".equals(it.next().getName());
    }

}

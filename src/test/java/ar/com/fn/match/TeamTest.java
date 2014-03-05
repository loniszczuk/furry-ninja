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
        t.addKicker(new SimpleKicker(1, 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker(1, 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker(1, 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker(1, 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addKicker(new SimpleKicker(1, 1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));

        Iterator<Kicker> it = t.kickers().iterator();

        assert t.getName().equals("Team 1");

        assert "Kicker 1".equals(it.next().getName());
        assert "Kicker 1".equals(it.next().getName());
        assert "Kicker 1".equals(it.next().getName());
        assert "Kicker 1".equals(it.next().getName());
        assert "Kicker 1".equals(it.next().getName());
    }

    @Test
    public void testGoalies() {

        Team t = new Team("Team 2");
        t.addGoalie(new SimpleGoalie(1,1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie(1,1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie(1,1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie(1,1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        t.addGoalie(new SimpleGoalie(1,1, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER, Position.CENTER));
        Iterator<Goalie> it = t.goalies().iterator();

        assert t.getName().equals("Team 2");

        assert "Goalie 1".equals(it.next().getName());
        assert "Goalie 1".equals(it.next().getName());
        assert "Goalie 1".equals(it.next().getName());
        assert "Goalie 1".equals(it.next().getName());
        assert "Goalie 1".equals(it.next().getName());
    }

}

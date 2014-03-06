package ar.com.fn.match;

import ar.com.fn.match.goalie.SimpleGoalie;
import ar.com.fn.match.kicker.SimpleKicker;
import org.testng.annotations.*;


public class MatchTest {

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


        Match m = new Match(t1, t2);

        State s = m.getCurrentState();

        assert s.isFinished();
        assert s.getWinner().equals(t2.getName());
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


        Match m = new Match(t1, t2);

        State s = m.getCurrentState();

        assert s.isFinished();
        assert s.getWinner().equals(t1.getName());
    }

}
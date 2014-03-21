package ar.com.fn.domain.match;

import ar.com.fn.domain.goalie.SimpleGoalie;
import ar.com.fn.domain.kicker.SimpleKicker;
import ar.com.fn.domain.matchmaking.User;
import ar.com.fn.domain.penalty.Position;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SimpleMatchResolverTest {

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


        SimpleMatchResolver m = new SimpleMatchResolver(new User("u1"), t1, new User("u2"), t2);

        Match s = m.getMatch();

        assertEquals(s.getWinner(), "u2");
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


        SimpleMatchResolver m = new SimpleMatchResolver(new User("u1"), t1, new User("u2"), t2);

        Match s = m.getMatch();

        assertEquals(s.getWinner(), "u1");
    }

}
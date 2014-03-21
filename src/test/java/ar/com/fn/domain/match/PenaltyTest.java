package ar.com.fn.domain.match;

import ar.com.fn.domain.goalie.Dive;
import ar.com.fn.domain.kicker.Kick;
import ar.com.fn.domain.penalty.ExecutedPenalty;
import ar.com.fn.domain.penalty.Penalty;
import ar.com.fn.domain.penalty.PenaltyResult;
import ar.com.fn.domain.penalty.Position;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by leandro on 5/3/14.
 */
public class PenaltyTest {

    @Test
    public void test() {
        Kick k = new Kick(Position.CENTER, 0);
        Map<Position, Float> c = new HashMap<Position, Float>();
        c.put(Position.CENTER, 1.f);
        Dive d = new Dive(c);
        Penalty p = new Penalty(k, d);

        ExecutedPenalty r = p.execute();

        assertEquals(r.isGoal(), false);
        assertEquals(r.getKick().getPosition(), Position.CENTER);
        assertEquals(r.getDive().getDominantPosition(), Position.CENTER);

    }

    @Test
    public void test2() {
        Kick k = new Kick(Position.CENTER, 1);
        Map<Position, Float> c = new HashMap<Position, Float>();
        c.put(Position.CENTER, 0.001f);
        Dive d = new Dive(c);
        Penalty p = new Penalty(k, d);

        ExecutedPenalty r = p.execute();

        assertEquals(r.isGoal(), true);
        assertEquals(r.getKick().getPosition(), Position.CENTER);
        assertEquals(r.getDive().getDominantPosition(), Position.CENTER);

    }


}

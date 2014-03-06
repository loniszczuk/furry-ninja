package ar.com.fn.match;

import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.kicker.Kick;
import ar.com.fn.match.penalty.Penalty;
import ar.com.fn.match.penalty.Result;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

        Result r = p.execute();

        assert r.isGoal() == false;
        assert r.getKickPosition() == Position.CENTER;
        assert r.getDivePosition() == Position.CENTER;

    }

    @Test
    public void test2() {
        Kick k = new Kick(Position.CENTER, 1);
        Map<Position, Float> c = new HashMap<Position, Float>();
        c.put(Position.CENTER, 0.001f);
        Dive d = new Dive(c);
        Penalty p = new Penalty(k, d);

        Result r = p.execute();

        assert r.isGoal() == true;
        assert r.getKickPosition() == Position.CENTER;
        assert r.getDivePosition() == Position.CENTER;

    }


}

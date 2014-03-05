package ar.com.fn.match;

import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.kicker.Kick;
import ar.com.fn.match.penalty.Penalty;
import ar.com.fn.match.penalty.Result;
import org.testng.annotations.Test;

/**
 * Created by leandro on 5/3/14.
 */
public class PenaltyTest {

    @Test
    public void test() {
        Kick k = new Kick(Position.CENTER, 1, 1);
        Dive d = new Dive(Position.CENTER, 1, 1);
        Penalty p = new Penalty(k, d);

        Result r = p.execute();

        assert r.isGoal() == false;
        assert r.getKickPosition() == Position.CENTER;
        assert r.getDivePosition() == Position.CENTER;

    }
}

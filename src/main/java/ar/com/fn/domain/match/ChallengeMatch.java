package ar.com.fn.domain.match;

import ar.com.fn.domain.goalie.Goalie;
import ar.com.fn.domain.kicker.Kicker;
import ar.com.fn.domain.penalty.Penalty;
import ar.com.fn.domain.penalty.Result;

import java.util.Iterator;

public class ChallengeMatch extends Match {

	private static final long serialVersionUID = -7632615642884449005L;

	private State state = new State(this.getId());

    private Team t1;
    private Team t2;

    private int team1Score = 0;
    private int team2Score = 0;

    public ChallengeMatch(Team t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.resolve();
    }

    private void resolve() {
        Iterator<Kicker> kickers1 = t1.kickers().iterator();
        Iterator<Goalie> goalies1 = t1.goalies().iterator();

        Iterator<Kicker> kickers2 = t2.kickers().iterator();
        Iterator<Goalie> goalies2 = t2.goalies().iterator();

//        int goals = 0;
        for (int i = 0; i < 5; ++i) {
            Penalty p = new Penalty(kickers1.next().kick(), goalies2.next().dive());
            Result r = p.execute();

            state.getMatchLog().addMove(r);

            if (r.isGoal()) {
                ++team1Score;
            }


            Penalty p2 = new Penalty(kickers2.next().kick(), goalies1.next().dive());
            Result r2 = p2.execute();

            state.getMatchLog().addMove(r2);

            if (r2.isGoal()) {
                ++team2Score;
            }

        }

        state.setFinished(true);
        if (team1Score > team2Score) {
            state.setWinner(t1.getName());
        } else if (team1Score < team2Score) {
            state.setWinner(t2.getName());
        } else {
            state.setWinner("Tie");
        }

    }

    public State getCurrentState() {
        return state;
    }
}

package ar.com.fn.match;

import ar.com.fn.goalie.Goalie;
import ar.com.fn.kicker.Kicker;
import ar.com.fn.penalty.Penalty;
import ar.com.fn.penalty.Result;

import java.util.Iterator;

public class SimpleMatch extends Match {

	private static final long serialVersionUID = 356312685451209485L;

	private State state = new State(this.getId());

    private Team t1;
    private Team t2;

    public SimpleMatch(Team t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
        this.resolve();
    }

    private void resolve() {
        Iterator<Kicker> kickers = t1.kickers().iterator();
        Iterator<Goalie> goalies = t2.goalies().iterator();

        int goals = 0;
        for (int i = 0; i < 5; ++i) {
            Penalty p = new Penalty(kickers.next().kick(), goalies.next().dive());
            Result r = p.execute();

            state.getMatchLog().addMove(r);

            if (r.isGoal()) {
                ++goals;
                if (goals > 2) break;
            }
        }

        state.setFinished(true);
        state.setWinner(goals > 2 ? t1.getName() : t2.getName());
    }

	public State getCurrentState() {
		return state;
	}

}
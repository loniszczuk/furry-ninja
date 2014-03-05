package ar.com.fn.match;

import ar.com.fn.match.goalie.Goalie;
import ar.com.fn.match.kicker.Kicker;
import ar.com.fn.match.penalty.Penalty;
import ar.com.fn.match.penalty.Result;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Match {

	private State state = new State();

	private Map<String, int[]> movesByPlayer = new LinkedHashMap<String, int[]>();
    private Team t1;
    private Team t2;

    public Match(Team t1, Team t2) {
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

    public void addMovements(String player, int[] movements) {
		this.movesByPlayer.put(player, movements);

		if (this.movesByPlayer.size() == 2) {
			Iterator<Map.Entry<String, int[]>> it = movesByPlayer.entrySet().iterator();
			Map.Entry<String, int[]> kicker = it.next();
			Map.Entry<String, int[]> goalie = it.next();

			state.getMatchLog().setPlayer1(kicker.getKey() + (" (kicker)"));
			state.getMatchLog().setPlayer2(goalie.getKey() + (" (goalie)"));

			int k = kicker.getValue().length;

			int goals = 0;
		}
	}

	public State getCurrentState() {
		return state;
	}

}
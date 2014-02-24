package ar.com.fn.match;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Match {

	private State state = new State();

	private Map<String, int[]> movesByPlayer = new LinkedHashMap<String, int[]>();

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
			for (int i = 0; i < k; ++i) {
				Move moveResult = new Move();
				state.getMatchLog().addMove(moveResult);
				moveResult.setPlayer1(kicker.getValue()[i]);
				moveResult.setPlayer2(goalie.getValue()[i]);
				if (kicker.getValue()[i] != goalie.getValue()[i]) {
					++goals;
					moveResult.setPoint("player1");
					if (goals > 2) break;
				} else {
					moveResult.setPoint("player2");
				}
			}
			state.setFinished(true);
			state.setWinner(goals > 2 ? kicker.getKey() : goalie.getKey());
		}
	}

	public State getCurrentState() {
		return state;
	}
}
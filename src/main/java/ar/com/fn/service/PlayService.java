package ar.com.fn.service;

import ar.com.fn.match.Match;
import ar.com.fn.match.State;

/**
 * @author jformoso
 */
public class PlayService {

	public static String resolveMatch(String player1, int[] movesPlayer1, String player2, int[] movesPlayer2) {
        Match m = new Match();

        m.addMovements(player1, movesPlayer1);
        m.addMovements(player2, movesPlayer2);

        State s = m.getCurrentState();

        return s.getWinner();
	}
}

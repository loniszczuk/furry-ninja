package ar.com.fn.match;

import ar.com.fn.match.penalty.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jformoso
 */
public class MatchLog {
	private String player1;
	private String player2;
	private List<Result> results = new ArrayList<Result>();

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public List<Result> getMoves() {
		return results;
	}

	public void addMove(Result result) {
		this.results.add(result);
	}
}

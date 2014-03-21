package ar.com.fn.domain.match;

import ar.com.fn.domain.penalty.PenaltyResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jformoso
 */
public class MatchLog {
	private List<PenaltyResult> penaltyResults = new ArrayList<PenaltyResult>();

	public List<PenaltyResult> getMoves() {
		return penaltyResults;
	}

	public void addMove(PenaltyResult penaltyResult) {
		this.penaltyResults.add(penaltyResult);
	}
}

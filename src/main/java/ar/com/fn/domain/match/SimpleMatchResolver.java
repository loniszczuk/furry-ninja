package ar.com.fn.domain.match;

import ar.com.fn.domain.goalie.Goalie;
import ar.com.fn.domain.kicker.Kicker;
import ar.com.fn.domain.matchmaking.User;
import ar.com.fn.domain.penalty.ExecutedPenalty;
import ar.com.fn.domain.penalty.Penalty;
import ar.com.fn.domain.penalty.PenaltyResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleMatchResolver extends MatchResolver {

	private static final int TOTAL_PENALTIES = 5;

	private static final long serialVersionUID = 356312685451209485L;

	private Match match;

    private User playerOne;
    private Team teamOne;
    private User playerTwo;
    private Team teamTwo;

    public SimpleMatchResolver(User playerOne, Team teamOne, User playerTwo, Team teamTwo) {
        this.playerOne = playerOne;
        this.teamOne = teamOne;
        this.playerTwo = playerTwo;
        this.teamTwo = teamTwo;
        this.resolve();
    }

    private void resolve() {
        Iterator<Kicker> kickers = teamOne.kickers().iterator();
        Iterator<Goalie> goalies = teamTwo.goalies().iterator();

        List<PenaltyResult> penalties = new ArrayList<>();

        int goals = 0;
        for (int i = 0; i < TOTAL_PENALTIES; ++i) {
            Kicker kicker = kickers.next();
            Goalie goalie = goalies.next();
            Penalty p = new Penalty(kicker.kick(), goalie.dive());
            ExecutedPenalty ep = p.execute();

            PenaltyResult res = new PenaltyResult(
                    playerOne.getUsername(), kicker.getName(), ep.getKick().getPosition(),
                    playerTwo.getUsername(), goalie.getName(), ep.getDive().getDominantPosition(),
                    ep.isGoal());
            penalties.add(res);

            if (res.isGoal()) {
                ++goals;
                if (goals > 2) break;
            }
        }
        Score score = new Score(goals, 0);
        String winner = goals > 2 ? playerOne.getUsername() : playerTwo.getUsername();

        this.match = new Match(playerOne.getUsername(), playerTwo.getUsername(), winner, score, penalties);
    }

	public Match getMatch() {
		return match;
	}

}
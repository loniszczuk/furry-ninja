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

public class ChallengeMatchResolver extends MatchResolver {

	private static final long serialVersionUID = -7632615642884449005L;

	private Match match;

    private User playerOne;
    private Team teamOne;
    private User playerTwo;
    private Team teamTwo;

    private int team1Score = 0;
    private int team2Score = 0;

    public ChallengeMatchResolver(User playerOne, Team teamOne, User playerTwo, Team teamTwo) {
        this.playerOne = playerOne;
        this.teamOne = teamOne;
        this.playerTwo = playerTwo;
        this.teamTwo = teamTwo;
        this.resolve();
    }

    private void resolve() {
        Iterator<Kicker> kickers1 = teamOne.kickers().iterator();
        Iterator<Goalie> goalies1 = teamOne.goalies().iterator();

        Iterator<Kicker> kickers2 = teamTwo.kickers().iterator();
        Iterator<Goalie> goalies2 = teamTwo.goalies().iterator();


        List<PenaltyResult> penalties = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            Kicker kicker1 = kickers1.next();
            Goalie goalie2 = goalies2.next();

            Penalty p = new Penalty(kicker1.kick(), goalie2.dive());
            ExecutedPenalty ep = p.execute();

            PenaltyResult res = new PenaltyResult(
                    playerOne.getUsername(), kicker1.getName(), ep.getKick().getPosition(),
                    playerTwo.getUsername(), goalie2.getName(), ep.getDive().getDominantPosition(),
                    ep.isGoal());
            penalties.add(res);

            if (res.isGoal()) {
                ++team1Score;
            }

            Kicker kicker2 = kickers2.next();
            Goalie goalie1 = goalies1.next();

            Penalty p2 = new Penalty(kicker2.kick(), goalie1.dive());
            ExecutedPenalty ep2 = p2.execute();

            PenaltyResult res2 = new PenaltyResult(
                    playerTwo.getUsername(), kicker2.getName(), ep2.getKick().getPosition(),
                    playerOne.getUsername(), goalie1.getName(), ep2.getDive().getDominantPosition(),
                    ep.isGoal());

            penalties.add(res2);

            if (res2.isGoal()) {
                ++team2Score;
            }

        }

        String winner;
        if (team1Score > team2Score) {
            winner = playerOne.getUsername();
        } else if (team1Score < team2Score) {
            winner = playerTwo.getUsername();
        } else {
            winner = "Tie";
        }
        Score score = new Score(team1Score, team2Score);

        this.match = new Match(playerOne.getUsername(), playerTwo.getUsername(), winner, score, penalties);

    }

    public Match getMatch() {
        return match;
    }
}

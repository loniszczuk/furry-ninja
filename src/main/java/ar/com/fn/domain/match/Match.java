package ar.com.fn.domain.match;

import ar.com.fn.domain.storage.Identificable;
import ar.com.fn.utils.IdGenerator;
import org.joda.time.DateTime;

public class Match extends Identificable {

    private DateTime timestamp;

    private String playerOne;
    private String playerTwo;

    private String winner;
    private Score score;
    private MatchLog matchLog = new MatchLog();

    public Match(String playerOne, String playerTwo, String winner, Score score, MatchLog matchLog) {
        this.id = IdGenerator.generate();
        this.timestamp = DateTime.now();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = winner;
        this.score = score;
        this.matchLog = matchLog;

        Matches.instance().registerMatch(this);
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String getWinner() {
        return winner;
    }

    public Score getScore() {
        return score;
    }

    public MatchLog getMatchLog() {
        return matchLog;
    }
}
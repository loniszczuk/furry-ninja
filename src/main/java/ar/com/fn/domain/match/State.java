package ar.com.fn.domain.match;

public class State {

	private String matchId;
    private boolean finished = false;
    private String winner;
    private MatchLog matchLog = new MatchLog();

    public State(String matchId) {
        this.matchId = matchId;
    }

    public boolean isFinished() {
        return finished;
    }

    public String getWinner() {
        if (winner == null) {
            throw new RuntimeException("No winner yet");
        }
        return winner;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setWinner(String winner) {
        if (winner == null) {
            throw new IllegalArgumentException("'winner' can't be null");
        }
        this.winner = winner;
    }

	public MatchLog getMatchLog() {
		return matchLog;
	}

	public void setMatchLog(MatchLog matchLog) {
		this.matchLog = matchLog;
	}

	public String getMatchId() {
		return matchId;
	}

}
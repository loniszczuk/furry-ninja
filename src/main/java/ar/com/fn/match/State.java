package ar.com.fn.match;

public class State {

    private boolean finished = false;
    private String winner;

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
}
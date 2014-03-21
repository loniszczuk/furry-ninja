package ar.com.fn.domain.match;

public class Score {
    private int playerOneGoals;
    private int playerTwoGoals;

    public Score(int playerOneGoals, int playerTwoGoals) {
        this.playerOneGoals = playerOneGoals;
        this.playerTwoGoals = playerTwoGoals;
    }

    public int getPlayerOneGoals() {
        return playerOneGoals;
    }

    public int getPlayerTwoGoals() {
        return playerTwoGoals;
    }

}

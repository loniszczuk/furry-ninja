package ar.com.fn.domain.penalty;

public class Result {

    private Position kickPosition;
    private Position divePosition;
    private boolean goal;

    public Result(boolean isGoal, Position kickPosition, Position divePosition) {
        this.kickPosition = kickPosition;
        this.divePosition = divePosition;
        this.goal = isGoal;
    }

    public Position getKickPosition() {
        return kickPosition;
    }

    public Position getDivePosition() {
        return divePosition;
    }

    public boolean isGoal() {
        return goal;
    }
}

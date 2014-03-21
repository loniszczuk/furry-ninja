package ar.com.fn.domain.penalty;

public class PenaltyResult {

    private String kickerPlayer;
    private String goaliePlayer;
    private Position kickPosition;
    private String kickerName;
    private String goalieName;
    private Position divePosition;
    private boolean goal;

    public PenaltyResult(String kickerPlayer, String kickerName, Position kickPosition,
                         String goaliePlayer, String goalieName, Position divePosition,
                         boolean goal) {
        this.kickerPlayer = kickerPlayer;
        this.goaliePlayer = goaliePlayer;
        this.kickerName = kickerName;
        this.goalieName = goalieName;
        this.kickPosition = kickPosition;
        this.divePosition = divePosition;
        this.goal = goal;
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

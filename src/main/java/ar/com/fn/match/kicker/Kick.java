package ar.com.fn.match.kicker;

import ar.com.fn.match.Position;

public class Kick {

    private Position position;
    private float goalProbability;

    public Kick(Position position, float goalProbability) {
        this.position = position;
        this.goalProbability = goalProbability;
    }

    public Position getPosition() {
        return position;
    }

    public float getGoalProbability() {
        return goalProbability;
    }
}

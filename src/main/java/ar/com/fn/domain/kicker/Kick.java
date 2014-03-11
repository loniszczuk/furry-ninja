package ar.com.fn.domain.kicker;

import ar.com.fn.domain.penalty.Position;

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

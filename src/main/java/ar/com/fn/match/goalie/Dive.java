package ar.com.fn.match.goalie;

import ar.com.fn.match.Position;

import java.util.Map;

public class Dive {

    private Map<Position, Float> coverage;
    private Position dominantPosition;

    public Dive(Map<Position, Float> coverage) {
        this.coverage = coverage;


        Position c = Position.values()[0];
        float prob = 0.f;

        for (Position p : Position.values()) {
            if (prob <= getBlockProbability(p)) {
                c = p;
                prob = getBlockProbability(p);
            }
        }
        this.dominantPosition = c;
    }

    public float getBlockProbability(Position p) {
        if (coverage.containsKey(p)) {
            return coverage.get(p).floatValue();
        } else {
            return 0.f;
        }

    }

    public Position getDominantPosition() {
        return dominantPosition;
    }
}

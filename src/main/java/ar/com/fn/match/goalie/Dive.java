package ar.com.fn.match.goalie;

import ar.com.fn.match.Position;

public class Dive {

    private Position position;
    private int power;
    private float precision;

    public Dive(Position position, int power, float precision) {
        this.position = position;
        this.power = power;
        this.precision = precision;
    }

    public Position getPosition() {
        return position;
    }

    public int getPower() {
        return power;
    }

    public float getPrecision() {
        return precision;
    }
}

package ar.com.fn.match.kicker;

import ar.com.fn.match.Position;

public class Kick {

    private Position position;
    private int power;
    private float precision;

    public Kick(Position position, int power, float precision) {
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

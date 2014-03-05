package ar.com.fn.match.goalie;

import ar.com.fn.match.Position;

public class SimpleGoalie extends Goalie {

    private Position[] positions;
    private int nextDive = 0;


    public SimpleGoalie(int power, float precision, Position... positions) {
        super(power, precision);
        this.positions = positions;
    }

    public Dive dive() {
        return new Dive(positions[nextDive++], this.power, this.precision);
    }
}

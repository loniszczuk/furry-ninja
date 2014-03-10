package ar.com.fn.kicker;

import ar.com.fn.penalty.Position;

public class SimpleKicker extends Kicker {

    private Position[] positions;
    private int nextKick = 0;


    public SimpleKicker(String name, float probability, Position... positions) {
        super(name, probability);
        this.positions = positions;
    }

    public Kick kick() {
        return new Kick(positions[nextKick++], this.probability);
    }
}

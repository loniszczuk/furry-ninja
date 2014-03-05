package ar.com.fn.match.kicker;

import ar.com.fn.match.Position;

/**
 * Created by leandro on 5/3/14.
 */
public class SimpleKicker extends Kicker {

    private Position[] positions;
    private int nextKick = 0;


    public SimpleKicker(int power, float precision, Position... positions) {
        super(power, precision);
        this.positions = positions;
        this.positions = positions;
    }

    public Kick kick() {
        return new Kick(positions[nextKick++], this.power, this.precision);
    }
}

package ar.com.fn.match.goalie;

import ar.com.fn.match.Position;

import java.util.HashMap;
import java.util.Map;

public class SimpleGoalie extends Goalie {

    private Position[] positions;
    private int nextDive = 0;


    public SimpleGoalie(String name, float coverage, Position... positions) {
        super(name, coverage);
        this.positions = positions;
    }

    public Dive dive() {
        Map<Position, Float> c = new HashMap<Position, Float>();
        c.put(positions[nextDive++], this.coverage);
        return new Dive(c);
    }

}

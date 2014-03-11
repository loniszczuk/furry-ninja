package ar.com.fn.domain.ai;

import ar.com.fn.domain.penalty.Position;
import ar.com.fn.domain.goalie.Dive;
import ar.com.fn.domain.goalie.Goalie;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AdvancedBot extends Goalie {

    private Random rand = new Random();

    public AdvancedBot() {
        super("Pro Bot", 2.f);
    }

    @Override
    public Dive dive() {
        Position p = Position.values()[rand.nextInt(3)];

        Map<Position, Float> cov = new HashMap<Position, Float>();

        cov.put(p, this.coverage*0.7f);
        if (p.equals(Position.CENTER)) {
            cov.put(Position.LEFT, this.coverage*0.15f);
            cov.put(Position.RIGHT, this.coverage*0.15f);
        } else {
            cov.put(Position.CENTER, this.coverage*0.3f);
        }

        return new Dive(cov);
    }

}

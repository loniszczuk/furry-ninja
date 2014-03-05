package ar.com.fn.ai;

import ar.com.fn.match.Position;
import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.goalie.Goalie;

import java.util.Random;

/**
 * @author jformoso
 */
public class Bot extends Goalie {

    private Random rand = new Random();

    public Bot() {
        super(1, 1.f);
    }

    @Override
    public Dive dive() {
        return new Dive(Position.values()[rand.nextInt(2+1)], this.power, this.precision);
    }

    public String getName() {
		return "Random Bot";
	}
}

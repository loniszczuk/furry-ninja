package ar.com.fn.match.goalie;


public abstract class Goalie {

    protected int power;
    protected float precision;

    public Goalie(int power, float precision) {
        this.power = power;
        this.precision = precision;
    }

    public abstract Dive dive();

    public String getName() {
        return "Goalie 1";
    }
}

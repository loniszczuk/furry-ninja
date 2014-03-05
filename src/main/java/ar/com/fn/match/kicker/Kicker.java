package ar.com.fn.match.kicker;

public abstract class Kicker {

    protected int power;
    protected float precision;

    public Kicker(int power, float precision) {
        this.power = power;
        this.precision = precision;
    }

    public abstract Kick kick();

    public String getName() {
        return "Kicker 1";
    }
}

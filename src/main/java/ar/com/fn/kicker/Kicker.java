package ar.com.fn.kicker;

public abstract class Kicker {

    private String name;
    protected float probability;

    public Kicker(String name, float probability) {
        this.name = name;
        this.probability = probability;
    }

    public abstract Kick kick();

    public final String getName() {
        return this.name;
    }
}

package ar.com.fn.domain.goalie;


public abstract class Goalie {

    private String name;
    protected float coverage;

    public Goalie(String name, float coverage) {
        this.name = name;
        this.coverage = coverage;
    }

    public final String getName() {
        return this.name;
    }

    public abstract Dive dive();
}

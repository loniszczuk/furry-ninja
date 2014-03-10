package ar.com.fn.match;

import ar.com.fn.utils.IdGenerator;

public abstract class Match {

    private String id = IdGenerator.generate();

    protected Match() {
        Matches.instance().registerMatch(this);
    }

    public String getId() {
        return this.id;
    }

    public abstract State getCurrentState();
}

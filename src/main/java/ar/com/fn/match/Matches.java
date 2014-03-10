package ar.com.fn.match;

import ar.com.fn.storage.IdentificableHandler;
import ar.com.fn.storage.MemoryHandler;

public class Matches {

    private static final Matches instance = new Matches();

    public static final Matches instance() {
        return instance;
    }

    private IdentificableHandler<Match> matches = new MemoryHandler<>();

    private Matches() {
    }

    public void registerMatch(Match match) {
        this.matches.save(match);
    }

    public Match getMatch(String id) {
        return this.matches.get(id);
    }
}

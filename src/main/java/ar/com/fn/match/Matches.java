package ar.com.fn.match;

import java.util.HashMap;
import java.util.Map;

public class Matches {

    private static final Matches instance = new Matches();

    public static final Matches instance() {
        return instance;
    }


    private Map<String, Match> matches = new HashMap<>();

    private Matches() {
    }

    public void registerMatch(Match match) {
        this.matches.put(match.getId(), match);
    }

    public Match getMatch(String id) {
        return this.matches.get(id);
    }
}

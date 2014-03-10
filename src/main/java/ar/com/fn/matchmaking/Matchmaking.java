package ar.com.fn.matchmaking;

import ar.com.fn.match.Team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Matchmaking {

    private static final Matchmaking instance = new Matchmaking();

    public static final Matchmaking instance() {
        return instance;
    }

    private Map<String, Challenge> challenges = new HashMap<>();


    private Matchmaking() {
    }

    public Challenge challenge(User challenger, Team challengerTeam,User challenged) {

        Challenge c = new Challenge(challenger, challengerTeam, challenged);
        this.challenges.put(c.getId(), c);

        return c;
    }

    public Challenge getChallenge(String id) {
        return this.challenges.get(id);
    }

}

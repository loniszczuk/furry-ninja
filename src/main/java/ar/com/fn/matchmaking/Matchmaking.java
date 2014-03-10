package ar.com.fn.matchmaking;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;

import java.util.Collection;

import org.hamcrest.core.IsEqual;

import ar.com.fn.match.Team;
import ar.com.fn.storage.MemoryHandler;

public class Matchmaking {
	private static final Matchmaking instance = new Matchmaking();

	public static final Matchmaking instance() {
		return instance;
	}

	private MemoryHandler<Challenge> challenges = new MemoryHandler<>();

	private Matchmaking() {
	}

	public Challenge challenge(User challenger, Team challengerTeam, User challenged) {
		Challenge c = new Challenge(challenger, challengerTeam, challenged);
		this.challenges.save(c);

		return c;
	}

	public Challenge getChallenge(String id) {
		return this.challenges.get(id);
	}

	public Collection<Challenge> getActiveChallenges(User u) {
		return this.challenges.getAll(having(on(Challenge.class).getChallenged().getUsername(), IsEqual.equalTo(u.getUsername())));
	}
}

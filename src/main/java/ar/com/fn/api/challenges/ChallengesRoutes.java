package ar.com.fn.api.challenges;

import ar.com.fn.JsonRoute;
import ar.com.fn.domain.goalie.Goalie;
import ar.com.fn.domain.goalie.SimpleGoalie;
import ar.com.fn.domain.kicker.Kicker;
import ar.com.fn.domain.kicker.SimpleKicker;
import ar.com.fn.domain.match.*;
import ar.com.fn.domain.matchmaking.Challenge;
import ar.com.fn.domain.matchmaking.Matchmaking;
import ar.com.fn.domain.matchmaking.User;
import ar.com.fn.domain.penalty.Position;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.patch;
import static spark.Spark.post;

public class ChallengesRoutes {

	private static final Position[] a = new Position[0];
	private static Gson gson = new Gson();

	public static void registerRoutes() {
		// desafiar a un usuario
		post(new Route("/challenges") {
			@Override
			public Object handle(Request request, Response response) {
				ChallengeRequest r = gson.fromJson(request.body(), ChallengeRequest.class);
				User challenger = new User(r.getChallenger());
				User challenged = new User(r.getChallenged());

				Team challengerTeam = new Team(challenger.getUsername() + "'s Team");

				Goalie g = new SimpleGoalie(challenger.getUsername() + "'s Goalie", 1.f, r.getDives().toArray(a));
				challengerTeam.addGoalie(g);

				Kicker k = new SimpleKicker(challenger.getUsername() + "'s Kicker", 1.f, r.getKicks().toArray(a));
				challengerTeam.addKicker(k);

				Challenge challenge = Matchmaking.instance().challenge(challenger, challengerTeam, challenged);

				response.status(201);
				response.header("Location", "/challenges/" + challenge.getId());
				return "";
			}
		});

		// obtener challenge
		get(new JsonRoute("/challenges/:id") {

			@Override
			public Object handle(Request request, Response response) {
				Challenge c = Matchmaking.instance().getChallenge(request.params("id"));
				response.status(200);

				return c;
			}
		});

		// aceptar desafio
		patch(new JsonRoute("/challenges/:id") {

			@Override
			public Object handle(Request request, Response response) {
				Challenge c = Matchmaking.instance().getChallenge(request.params("id"));
				ChallengeAcceptedRequest r = gson.fromJson(request.body(), ChallengeAcceptedRequest.class);

				Team challengedTeam = new Team(c.getChallenged().getUsername() + "'s Team");

				Goalie g = new SimpleGoalie(c.getChallenged().getUsername() + "'s Goalie", 1.f, r.getDives().toArray(a));
				challengedTeam.addGoalie(g);

				Kicker k = new SimpleKicker(c.getChallenged().getUsername() + "'s Kicker", 1.f, r.getKicks().toArray(a));
				challengedTeam.addKicker(k);

				c.setChallengedTeam(challengedTeam);

				Match m = new ChallengeMatch(c.getChallengerTeam(), c.getChallengedTeam());

				c.setMatchId(m.getId());

				State state = m.getCurrentState();

				response.status(200);

				return state;
			}
		});

	}
}

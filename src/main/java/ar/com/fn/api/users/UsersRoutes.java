package ar.com.fn.api.users;

import static ch.lambdaj.Lambda.convert;
import static ch.lambdaj.Lambda.map;
import static spark.Spark.get;

import static ch.lambdaj.Lambda.forEach;


import ar.com.fn.api.JsonRoute;
import ar.com.fn.api.challenges.ChallengeResponse;
import ar.com.fn.domain.matchmaking.Challenge;
import ch.lambdaj.function.convert.Converter;
import spark.Request;
import spark.Response;
import ar.com.fn.domain.matchmaking.Matchmaking;
import ar.com.fn.domain.matchmaking.User;

public class UsersRoutes {

	public static void registerRoutes() {
		// API METHODS
		get(new JsonRoute("/me/challenges") {
			@Override
			public Object handle(Request request, Response response) {
				// TODO: JMF: Obtener el id del query string es temporal mientras no tengamos login
				// Una vez que haya login cualquier metodo bajo /me/ implica el usuario logueado.
				User u = new User(request.queryParams("id"));
                return convert(Matchmaking.instance().getActiveChallenges(u), new Converter<Challenge, ChallengeResponse>() {
                    @Override
                    public ChallengeResponse convert(Challenge c) {
                        return ChallengeResponse.fromChallenge(c);
                    }
                });
			}
		});
	}
}

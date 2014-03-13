package ar.com.fn.api.users;

import ar.com.fn.api.JsonRoute;
import ar.com.fn.api.challenges.ChallengeResponse;
import ar.com.fn.domain.matchmaking.Challenge;
import ar.com.fn.domain.matchmaking.Matchmaking;
import ar.com.fn.domain.matchmaking.User;
import ar.com.fn.domain.matchmaking.Users;
import ar.com.fn.security.Authentication;
import ar.com.fn.security.AuthenticationResult;
import ar.com.fn.security.Tokens;
import ch.lambdaj.function.convert.Converter;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import spark.Request;
import spark.Response;

import java.util.Collection;

import static ch.lambdaj.Lambda.convert;
import static spark.Spark.get;
import static spark.Spark.post;

public class UsersRoutes {

	private static Gson gson = new Gson();

	public static void registerRoutes() {

		get(new JsonRoute("/users/:id/challenges") {
			@Override
			public Object handle(Request request, Response response) {
				User u = new User(request.params("id"));
				return convert(Matchmaking.instance().getActiveChallenges(u), new Converter<Challenge, ChallengeResponse>() {
					@Override
					public ChallengeResponse convert(Challenge c) {
						return ChallengeResponse.fromChallenge(c);
					}
				});
			}
		});
		
		// TEST METHOD
		get(new JsonRoute("/users/:id/creditcards") {
			@Override
			public Object handle(Request request, Response response) {
				AuthenticationResult res = Authentication.instance().validate(request.params("id"), request.queryParams("token"), 1);
				if (res.getCode() != 200) halt(res.getCode(), res.getMessage());
				
				return "4242424242424242";
			}
		});

		// auth and security
		post(new JsonRoute("/users") {
			@Override
			public Object handle(Request request, Response response) {
				RegistrationRequest r = gson.fromJson(request.body(), RegistrationRequest.class);

				if (Users.instance().exists(r.getEmail())) {
					halt(400, "User already exists -- " + r.getEmail());
				}

				User u = new User(r.getEmail(), DigestUtils.sha1Hex(r.getPassword()), r.getNickname());
				Users.instance().db().save(u);

				return new RegistrationResponse(new Session(Tokens.instance().createToken(u.getId(), 1), Tokens.instance().createToken(
						u.getId(), 2)), u.getId());
			}
		});
		
		post(new JsonRoute("/login") {
			@Override
			public Object handle(Request request, Response response) {
				LoginRequest r = gson.fromJson(request.body(), LoginRequest.class);

				User u = Users.instance().getByEmail(r.getEmail());
				if (u == null) {
					halt(404, "User not found -- " + r.getEmail());
				}
				
				if (!u.getPassword().equals(DigestUtils.sha1Hex(r.getPassword()))) {
					halt(401, "Invalid password or user -- " + r.getEmail());
				}

				return new LoginResponse(new Session(Tokens.instance().createToken(u.getId(), 1), Tokens.instance().createToken(
						u.getId(), 2)), u.getId());
			}
		});
        get(new JsonRoute("/users") {

            @Override
            public Object handle(Request request, Response response) {
                String status = request.params("status");
                if (status != null && status.equals("online")) {
                    Collection<User> users = Users.instance().getOnlineUsers();
                    return users;
                } else {
                    // Despues debería devolver todos los usuarios
                    Collection<User> users = Users.instance().getUsers();
                    return users;
                }
            }
        });
	}
}

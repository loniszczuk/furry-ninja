package ar.com.fn;

import static spark.Spark.get;
import spark.Request;
import spark.Response;
import ar.com.fn.matchmaking.Matchmaking;
import ar.com.fn.matchmaking.User;

public class UsersRoutes {

	public static void registerRoutes() {
		// API METHODS
		get(new JsonRoute("/me/challenges") { 
			@Override
			public Object handle(Request request, Response response) {
				// TODO: JMF: Obtener el id del query string es temporal mientras no tengamos login
				// Una vez que haya login cualquier metodo bajo /me/ implica el usuario logueado.
				User u = new User(request.queryParams("id"));
				return Matchmaking.instance().getActiveChallenges(u);
			}
		});
	}
}

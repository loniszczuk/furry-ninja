package ar.com.fn;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.util.Map;

import ar.com.fn.api.challenges.ChallengesRoutes;
import ar.com.fn.api.matches.MatchesRoutes;
import ar.com.fn.api.users.UsersRoutes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;
import ar.com.fn.domain.match.Matches;
import ar.com.fn.domain.match.State;
import ar.com.fn.domain.matchmaking.User;
import ar.com.fn.domain.matchmaking.Users;

import com.google.gson.Gson;

/**
 * @author jformoso
 */
@SuppressWarnings("unchecked")
public class Main {

    private static Gson gson = new Gson();

	public static void main(String[] args) {
		
		staticFileLocation("/public");

        MatchesRoutes.registerRoutes();
        ChallengesRoutes.registerRoutes();
        UsersRoutes.registerRoutes();

        // WEB METHODS (not used yet)

        post(new Route("/login") {
			public Object handle(Request request, Response response) {
                Map<Object, Object> body = gson.fromJson(request.body(), Map.class);
                String username = (String) body.get("username");
                User u = new User(username);
                Users.instance().setOnline(u);

                response.status(200);
                return "";
            }
        });

		get(new FreeMarkerRoute("/result/:id") {
			@Override
			public ModelAndView handle(Request request, Response response) {
				// The ftl files need to be located in the directory:
				// {resources-dir}/spark/template/freemarker
				// hence in maven: src/main/resources/spark/template/freemarker
				State state = Matches.instance().getMatch(request.params(":id")).getCurrentState();
				if (state == null) halt(404, "Not found!");
				return modelAndView(state, "result.ftl");
			}
		});
		
	}
}

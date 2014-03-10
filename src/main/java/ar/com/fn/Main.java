package ar.com.fn;

import java.util.Map;

import ar.com.fn.match.*;
import ar.com.fn.matchmaking.User;
import ar.com.fn.matchmaking.Users;
import ar.com.fn.penalty.Position;
import com.google.gson.Gson;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import static spark.Spark.*;

/**
 * @author jformoso
 */
public class Main {

    private static final Position[] a = new Position[0];
    private static Gson gson = new Gson();


	public static void main(String[] args) {
		
		staticFileLocation("/public");

        MatchesRoutes.registerRoutes();
        ChallengesRoutes.registerRoutes();

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

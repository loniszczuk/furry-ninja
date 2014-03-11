package ar.com.fn;

import static spark.Spark.staticFileLocation;
import ar.com.fn.api.challenges.ChallengesRoutes;
import ar.com.fn.api.matches.MatchesRoutes;
import ar.com.fn.api.users.UsersRoutes;
import ar.com.fn.web.WebRoutes;

/**
 * @author jformoso
 */
public class Main {

	public static void main(String[] args) {
		//static content
		staticFileLocation("/public");
		// api
		MatchesRoutes.registerRoutes();
		ChallengesRoutes.registerRoutes();
		UsersRoutes.registerRoutes();
		// web
		WebRoutes.registerRoutes();
	}
}

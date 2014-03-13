package ar.com.fn;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import spark.Request;
import spark.Response;
import spark.Route;
import ar.com.fn.api.JsonRoute;
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
		
		// temp
		get(new Route("/docs") {
			@Override
	         public Object handle(Request request, Response response) {
	            StringBuilder b = new StringBuilder();
	            b.append("Registered json routes: \r\n\r\n");
	            
	            for (int i = 0; i < JsonRoute.routes.size(); i++) {
					b.append(JsonRoute.routes.get(i) + "\r\n");
				}
	            
	            b.append("\r\nDue to Spark limitations, I can't know their methods :(");
	            
	            response.type("text/plain");
	            return b.toString();
	         }
		});
		
		get(new Route("/version") {
			@Override
	         public Object handle(Request request, Response response) {
	            response.type("text/plain");
	            return "http://blog.codinghorror.com/whats-in-a-version-number-anyway/";
	         }
		});
	}
}

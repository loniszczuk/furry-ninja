package ar.com.fn;
import static spark.Spark.*;
import ar.com.fn.ai.Bot;
import ar.com.fn.service.PlayService;
import spark.*;

/**
 * @author jformoso
 */
public class Main {
	public static void main(String[] args) {
		get(new Route("/play") {
			@Override
			public Object handle(Request request, Response response) {
				Bot b = new Bot();
				 String result = PlayService.resolveMatch(request.queryParams("name"), Utils.getIntArray(request.queryParams("moves")), b.getName(), b.getMoves());
				 
				 return "and the winner is: " + result;
			}
		});
	}
}

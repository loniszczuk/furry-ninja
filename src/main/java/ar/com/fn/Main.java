package ar.com.fn;

import static spark.Spark.*;
import ar.com.fn.ai.Bot;
import ar.com.fn.match.Match;
import spark.*;

/**
 * @author jformoso
 */
public class Main {
	public static void main(String[] args) {
		get(new JsonRoute("/play") {
			@Override
			public Object handle(Request request, Response response) {
				Match m = new Match();

				Bot b = new Bot();
		        m.addMovements(request.queryParams("name"), Utils.getIntArray(request.queryParams("moves")));
		        m.addMovements(b.getName(), b.getMoves());

				return m.getCurrentState();
			}
		});
	}
}

package ar.com.fn;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import ar.com.fn.ai.Bot;
import ar.com.fn.match.Match;
import ar.com.fn.match.State;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

/**
 * @author jformoso
 */
public class Main {
	
	private static Map<Integer, State> results = new HashMap<Integer, State>();
	private static Integer currentId = 1;
	public static void main(String[] args) {
		
		staticFileLocation("/public");
		
		get(new JsonRoute("/play") {
			@Override
			public Object handle(Request request, Response response) {
				Match m = new Match();

				Bot b = new Bot();
				m.addMovements(request.queryParams("name"), Utils.getIntArray(request.queryParams("moves")));
				m.addMovements(b.getName(), b.getMoves());

				State state = m.getCurrentState();
				state.setId(currentId);
				results.put(currentId, state);
				++currentId;
				return state;
			}
		});

		get(new FreeMarkerRoute("/result/:id") {
			@Override
			public ModelAndView handle(Request request, Response response) {
				// The ftl files need to be located in the directory:
				// {resources-dir}/spark/template/freemarker
				// hence in maven: src/main/resources/spark/template/freemarker
				State state = results.get(Integer.parseInt(request.params(":id")));
				if (state == null) halt(404, "Not found!");
				return modelAndView(state, "result.ftl");
			}
		});
		
	}
}

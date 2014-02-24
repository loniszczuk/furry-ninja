package ar.com.fn;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import ar.com.fn.ai.Bot;
import ar.com.fn.match.Match;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

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

		get(new FreeMarkerRoute("/result") {
			@Override
			public ModelAndView handle(Request request, Response response) {
				Map<String, Object> attributes = new HashMap<>();
//				attributes.put("message", "Hello FreeMarker");

				// The ftl files need to be located in the directory:
				// {resources-dir}/spark/template/freemarker
				// hence in maven: src/main/resources/spark/template/freemarker
				return modelAndView(attributes, "result.ftl");
			}
		});
	}
}

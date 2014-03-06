package ar.com.fn;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import ar.com.fn.ai.Bot;
import ar.com.fn.match.Match;
import ar.com.fn.match.Position;
import ar.com.fn.match.State;
import ar.com.fn.match.Team;
import ar.com.fn.match.kicker.SimpleKicker;
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
                Team t1 = new Team("player");


                int[] moves = Utils.getIntArray(request.queryParams("moves"));
                Position[] p = new Position[5];
                for(int i=0; i<5; ++i) {p[i] = Position.values()[moves[i]];}

                t1.addKicker(new SimpleKicker("Jose", 1.f, p));

                Team t2 = new Team("bot");
                Bot b = new Bot();
                t2.addGoalie(b);

                Match m = new Match(t1, t2);

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

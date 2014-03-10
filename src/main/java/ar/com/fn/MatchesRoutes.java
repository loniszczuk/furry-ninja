package ar.com.fn;

import ar.com.fn.ai.Bot;
import ar.com.fn.kicker.SimpleKicker;
import ar.com.fn.match.Matches;
import ar.com.fn.match.SimpleMatch;
import ar.com.fn.match.Team;
import ar.com.fn.penalty.Position;
import ar.com.fn.requests.MatchRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.post;

public class MatchesRoutes {

    private static final Position[] a = new Position[0];
    private static Gson gson = new Gson();


    public static void registerRoutes() {
        // API METHODS
        get(new JsonRoute("/matches/:id") {
            @Override
            public Object handle(Request request, Response response) {
                return Matches.instance().getMatch(request.params("id"));
            }
        });

        // jugar contra un bot
        post(new JsonRoute("/matches") {
            @Override
            public Object handle(Request request, Response response) {

                MatchRequest r = gson.fromJson(request.body(), MatchRequest.class);

                Team playerTeam = new Team(r.getUsername() + "'s Team");

                playerTeam.addKicker(new SimpleKicker(r.getUsername() + "'s Kicker", 1.f, r.getKicks().toArray(a)));

                Team botTeam = new Team("Bot's Team");
                Bot b = new Bot();
                botTeam.addGoalie(b);

                SimpleMatch m = new SimpleMatch(playerTeam, botTeam);

                return m.getCurrentState();
            }
        });
    }
}

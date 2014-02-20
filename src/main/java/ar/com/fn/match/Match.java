package ar.com.fn.match;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Match {

    private State state = new State();

    private Map<String, int[]> movesByPlayer = new LinkedHashMap<String, int[]>();


    public void addMovements(String player, int[] movements) {
        this.movesByPlayer.put(player, movements);

        if (this.movesByPlayer.size() == 2) {
            Iterator<Map.Entry<String, int[]>> it = movesByPlayer.entrySet().iterator();
            Map.Entry<String, int[]> kicker = it.next();
            Map.Entry<String, int[]> goalie = it.next();

            int k = kicker.getValue().length;

            int goals = 0;
            for(int i = 0; i<k; ++i) {
                if (kicker.getValue()[i] != goalie.getValue()[i]) {
                    ++goals;
                }
            }
            state.setFinished(true);
            state.setWinner(goals > 2? kicker.getKey(): goalie.getKey());
        }
    }

    public State getCurrentState() {
        return state;
    }
}
package ar.com.fn.requests;

import ar.com.fn.penalty.Position;

import java.util.List;

public class ChallengeAcceptedRequest {

    private List<Position> kicks;
    private List<Position> dives;

    public List<Position> getKicks() {
        return kicks;
    }

    public void setKicks(List<Position> kicks) {
        this.kicks = kicks;
    }

    public List<Position> getDives() {
        return dives;
    }

    public void setDives(List<Position> dives) {
        this.dives = dives;
    }
}

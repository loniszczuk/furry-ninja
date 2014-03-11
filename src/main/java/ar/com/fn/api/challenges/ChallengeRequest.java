package ar.com.fn.api.challenges;

import ar.com.fn.domain.penalty.Position;

import java.util.List;

public class ChallengeRequest {

    private String challenger;
    private String challenged;
    private List<Position> kicks;
    private List<Position> dives;

    public String getChallenger() {
        return challenger;
    }

    public void setChallenger(String challenger) {
        this.challenger = challenger;
    }

    public String getChallenged() {
        return challenged;
    }

    public void setChallenged(String challenged) {
        this.challenged = challenged;
    }

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

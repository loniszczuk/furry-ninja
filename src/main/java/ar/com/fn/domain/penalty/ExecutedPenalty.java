package ar.com.fn.domain.penalty;

import ar.com.fn.domain.goalie.Dive;
import ar.com.fn.domain.kicker.Kick;

public class ExecutedPenalty {

    private boolean isGoal;
    private Kick kick;
    private Dive dive;

    public ExecutedPenalty(boolean isGoal, Kick kick, Dive dive) {
        this.isGoal = isGoal;
        this.kick = kick;
        this.dive = dive;
    }

    public boolean isGoal() {
        return isGoal;
    }

    public Kick getKick() {
        return kick;
    }

    public Dive getDive() {
        return dive;
    }
}

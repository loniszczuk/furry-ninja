package ar.com.fn.match.penalty;

import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.kicker.Kick;

public class Penalty {

    private Kick kick;
    private Dive dive;

    public Penalty(Kick k, Dive d) {
        this.kick = k;
        this.dive = d;
    }

    public Result execute() {
        return new Result(!kick.getPosition().equals(dive.getPosition()), kick.getPosition(), dive.getPosition());
    }
}

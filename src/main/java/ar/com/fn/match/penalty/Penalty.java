package ar.com.fn.match.penalty;

import ar.com.fn.match.Position;
import ar.com.fn.match.goalie.Dive;
import ar.com.fn.match.kicker.Kick;

import java.util.Random;

public class Penalty {

    private static final Random r = new Random();

    private Kick kick;
    private Dive dive;

    public Penalty(Kick k, Dive d) {
        this.kick = k;
        this.dive = d;
    }

    public Result execute() {
        Position position = kick.getPosition();
        float goalProbability = kick.getGoalProbability();

        float blockProbability = dive.getBlockProbability(position);

        float globalProbability = 0.5f + (goalProbability - blockProbability)/2;

        boolean isGoal = r.nextFloat() < globalProbability;

        return new Result(isGoal, kick.getPosition(), dive.getDominantPosition());
    }
}

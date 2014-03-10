package ar.com.fn.match;

import ar.com.fn.goalie.Goalie;
import ar.com.fn.kicker.Kicker;
import ar.com.fn.utils.RingIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 5/3/14.
 */
public class Team {

    private String name;
    private List<Kicker> kickers;
    private List<Goalie> goalies;

    public Team(String name) {
        this.name = name;
        this.kickers = new ArrayList<Kicker>();
        this.goalies = new ArrayList<Goalie>();
    }

    public void addKicker(Kicker k) {
        this.kickers.add(k);
    }

    public void addGoalie(Goalie g) {
        this.goalies.add(g);
    }

    public Iterable<Kicker> kickers() {
        return new RingIterator(this.kickers);
    }

    public Iterable<Goalie> goalies() {
        return new RingIterator(this.goalies);
    }


    public String getName() {
        return this.name;
    }

    public boolean equals(Team that) {
        return this.getName().equals(that.getName());
    }

}

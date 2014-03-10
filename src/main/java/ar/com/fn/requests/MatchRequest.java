package ar.com.fn.requests;

import ar.com.fn.penalty.Position;

import java.util.List;

public class MatchRequest {

    private String username;
    private List<Position> kicks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Position> getKicks() {
        return kicks;
    }

    public void setKicks(List<Position> kicks) {
        this.kicks = kicks;
    }
}

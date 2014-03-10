package ar.com.fn.matchmaking;

import ar.com.fn.match.Team;
import ar.com.fn.utils.IdGenerator;

import java.util.UUID;

public class Challenge {

    private String id;
    private long timestamp;

    private User challenger;
    private Team challengerTeam;

    private User challenged;
    private Team challengedTeam;

    private String matchId;

    public Challenge(User challenger, Team challengerTeam, User challenged) {

        this.id = IdGenerator.generate();
        this.timestamp = System.currentTimeMillis();
        this.challenger = challenger;
        this.challengerTeam = challengerTeam;
        this.challenged = challenged;
    }

    public boolean isReadyToMatch() {
        return this.challengerTeam != null && this.challengedTeam != null;
    }

    public String getId() {
        return this.id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setChallengedTeam(Team challenged) {
        this.challengedTeam = challenged;
    }

    public User getChallenger() {
        return challenger;
    }

    public Team getChallengerTeam() {
        return challengerTeam;
    }

    public User getChallenged() {
        return challenged;
    }

    public Team getChallengedTeam() {
        return challengedTeam;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}

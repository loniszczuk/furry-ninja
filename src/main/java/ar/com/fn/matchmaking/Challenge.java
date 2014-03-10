package ar.com.fn.matchmaking;

import ar.com.fn.match.Team;
import ar.com.fn.storage.Identificable;

public class Challenge extends Identificable {

	private static final long serialVersionUID = 6826954827548408759L;

	private long timestamp;

    private User challenger;
    private Team challengerTeam;

    private User challenged;
    private Team challengedTeam;

    private String matchId;

    public Challenge(User challenger, Team challengerTeam, User challenged) {
        this.timestamp = System.currentTimeMillis();
        this.challenger = challenger;
        this.challengerTeam = challengerTeam;
        this.challenged = challenged;
    }

    public boolean isReadyToMatch() {
        return this.challengerTeam != null && this.challengedTeam != null;
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

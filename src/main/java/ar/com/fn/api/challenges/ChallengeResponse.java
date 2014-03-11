package ar.com.fn.api.challenges;

import ar.com.fn.domain.matchmaking.Challenge;

public class ChallengeResponse {

    public static ChallengeResponse fromChallenge(Challenge c) {
        ChallengeResponse cr = new ChallengeResponse();

        cr.setId(c.getId());
        cr.setTimestamp(c.getTimestamp());
        cr.setMatchId(c.getMatchId());

        cr.setChallenger(c.getChallenger().getUsername());
        cr.setChallenged(c.getChallenged().getUsername());

        cr.setReadyToMatch(c.isReadyToMatch());

        return cr;
    }


    private String id;
    private long timestamp;
    private String matchId;

    private String challenger;
    private String challenged;

    private boolean readyToMatch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

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

    public boolean isReadyToMatch() {
        return readyToMatch;
    }

    public void setReadyToMatch(boolean readyToMatch) {
        this.readyToMatch = readyToMatch;
    }
}

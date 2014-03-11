package ar.com.fn.api.users;

/**
 * @author jformoso
 */
public class Session {
	private String level1Token;
    private String level2Token;

    public Session() {
        this(null, null);
    }

    public Session(String level1Token) {
    	this(level1Token, null);
    }
    public Session(String level1Token, String level2Token) {
        this.level1Token = level1Token;
        this.level2Token = level2Token;
    }

    public String getLevel1Token() {
        return this.level1Token;
    }

    public String getLevel2Token() {
        return this.level2Token;
    }
}

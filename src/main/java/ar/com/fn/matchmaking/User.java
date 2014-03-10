package ar.com.fn.matchmaking;

import ar.com.fn.storage.Identificable;

public class User extends Identificable {
	private static final long serialVersionUID = -3071984290122615095L;
	private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}

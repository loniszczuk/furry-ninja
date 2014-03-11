package ar.com.fn.domain.matchmaking;

import ar.com.fn.domain.storage.Identificable;

public class User extends Identificable {
	private static final long serialVersionUID = -3071984290122615095L;
	// TODO: Renombrar a nickname (va a ser no obligatorio!)
	private String username;
	private String email;
	private String password; // hashed

	public User(String username) {
		this(null,null,username);
	}
	
	public User(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}

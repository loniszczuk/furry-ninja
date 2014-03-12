package ar.com.fn.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import ar.com.fn.domain.storage.MemoryHandler;

public class Tokens {
	private static final Tokens instance = new Tokens();

	public static Tokens instance() {
		return instance;
	}
	
	// TODO: jmf: esto seguramente va a ser un CassandraHandler
	private MemoryHandler<Token> handler = new MemoryHandler<>();
	private static int[] timeToLiveByLevel;
	private SecureRandom random = new SecureRandom();

	static {
		timeToLiveByLevel = new int[3];
		timeToLiveByLevel[1] = 1209600;
		timeToLiveByLevel[2] = 900;
	}

	public String createToken(String userId, int level) {
		Token t = new Token();
		t.setId(this.nextSessionId());
		t.setUserId(userId);
		t.setLevel(level);
		t.setExpiration(new Date(new Date().getTime() + timeToLiveByLevel[level] * 1000));
		this.handler.save(t);

		return t.getId();
	}
	
	public Token get(String token) {
		return this.handler.get(token);
	}

	public void refresh(String userId, String token) {
		if (token != null) {
			Token t = this.handler.get(token);
			if (t != null) {
				t.setExpiration(new Date(new Date().getTime() + timeToLiveByLevel[t.getLevel()] * 1000));
			}
		}
	}

	private String nextSessionId() {
		return new BigInteger(130, this.random).toString(32);
	}
}

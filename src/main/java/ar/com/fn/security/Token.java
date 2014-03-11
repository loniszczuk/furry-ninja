package ar.com.fn.security;

import java.util.Date;

import ar.com.fn.domain.storage.Identificable;

/**
 * @author jformoso
 */
public class Token extends Identificable {

	private static final long serialVersionUID = 2852077840214248065L;

	private int level = 1;
	private String userId;
	// TODO: Esto es temporal, si lo metemos en un cassandra se maneja de otra
	// forma
	private Date expiration;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
}

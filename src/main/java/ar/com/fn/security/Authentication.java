package ar.com.fn.security;

import java.util.Date;

/**
 * @author jformoso
 */
public class Authentication {

	private static final Authentication instance = new Authentication();

	public static Authentication instance() {
		return instance;
	}

	public AuthenticationResult validate(String userId, String token, int requiredLevel) {
		Token t = Tokens.instance().get(token);

		if (t == null || new Date().getTime() > t.getExpiration().getTime()) {
			return new AuthenticationResult(404, "session not found");
		}

		if (!userId.equals(t.getUserId())) {
			return new AuthenticationResult(401, "invalid session");
		}

		Tokens.instance().refresh(userId, token);
		return new AuthenticationResult(200);
	}
}

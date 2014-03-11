package ar.com.fn.security;

/**
 * @author jformoso
 */
public class AuthenticationResult {
	private int code;
	private String message;
	
	public AuthenticationResult(int code) {
		this(code, null);
	}
	public AuthenticationResult(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

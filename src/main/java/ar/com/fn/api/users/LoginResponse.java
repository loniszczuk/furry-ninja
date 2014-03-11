package ar.com.fn.api.users;


public class LoginResponse {
	private Session session;
	private String userId;
	
	public LoginResponse(Session session, String userId) {
		this.session = session;
		this.userId = userId;
	}

	public Session getSession() {
		return session;
	}

	public String getUserId() {
		return userId;
	}
}

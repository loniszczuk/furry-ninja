package ar.com.fn.domain.matchmaking;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;

import java.util.Collection;
import java.util.Collections;

import org.hamcrest.core.IsEqual;

import ar.com.fn.domain.storage.IdentificableHandler;
import ar.com.fn.domain.storage.MemoryHandler;

public class Users {


	private static final Users instance = new Users();

	public static Users instance() {
		return instance;
	}

	private IdentificableHandler<User> onlineUsers = new MemoryHandler<>();
	private MemoryHandler<User> users = new MemoryHandler<>();

	public Collection<User> getOnlineUsers() {
		return Collections.unmodifiableCollection(onlineUsers.getAll());
	}

    public Collection<User> getUsers() {
        return Collections.unmodifiableCollection(onlineUsers.getAll());
    }

    public User getByEmail(String email) {
		Collection<User> all = this.users.getAll(having(on(User.class).getEmail(), IsEqual.equalTo(email)));
		if (all.size() < 1) return null;
		
		return all.iterator().next();
	}

    public User getByUsername(String username) {
        Collection<User> all = this.users.getAll(having(on(User.class).getUsername(), IsEqual.equalTo(username)));
        if (all.size() < 1) return null;

        return all.iterator().next();
    }


    public boolean exists(String email) {
		return this.getByEmail(email) != null;
	}

	public void setOnline(User u) {
		this.onlineUsers.add(u);
	}

	public void setOffline(User u) {
		this.onlineUsers.remove(u.getId());
	}
	
	public IdentificableHandler<User> db() {
		return this.users;
	}



}

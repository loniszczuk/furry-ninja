package ar.com.fn.domain.matchmaking;

import java.util.Collection;
import java.util.Collections;

import ar.com.fn.domain.storage.IdentificableHandler;
import ar.com.fn.domain.storage.MemoryHandler;

public class Users {

    private static final Users instance = new Users();

    public static Users instance() {
        return instance;
    }

    private IdentificableHandler<User> onlineUsers = new MemoryHandler<>();

    public Collection<User> getOnlineUsers() {
        return Collections.unmodifiableCollection(onlineUsers.getAll());
    }

    public void setOnline(User u) {
        this.onlineUsers.add(u);
    }

    public void setOffline(User u) {
        this.onlineUsers.remove(u.getId());
    }
}

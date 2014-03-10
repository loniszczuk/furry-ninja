package ar.com.fn.matchmaking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Users {

    private static final Users instance = new Users();

    public static Users instance() {
        return instance;
    }

    private Set<User> onlineUsers = new HashSet<>();

    public Set<User> getOnlineUsers() {
        return Collections.unmodifiableSet(onlineUsers);
    }

    public void setOnline(User u) {
        this.onlineUsers.add(u);
    }

    public void setOffline(User u) {
        this.onlineUsers.remove(u);
    }

}

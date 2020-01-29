package pl.gr4ss.core.managers;

import pl.gr4ss.core.object.User;

import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    private static final ConcurrentHashMap<String, User> users;

    static {
        users = new ConcurrentHashMap<String, User>();
    }

    public static User getUser(final String name) {
        for (final User u : UserManager.users.values()) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
    public static void createrUser(final String p) {
        final User u = new User(p);
        UserManager.users.put(p, u);
    }

}

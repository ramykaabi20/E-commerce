package LocalDB;

import Models.User;

import java.util.HashSet;

public final class LocalDB {
    private static LocalDB instance = null;
    private static HashSet<User> users = new HashSet<User>();

    private LocalDB() {
    }
    public static LocalDB getLocalDB() {
        if (instance == null) {
            instance = new LocalDB();
        }
        return instance;
    }
    public static void addUser(User user) {
        users.add(user);
    }
}

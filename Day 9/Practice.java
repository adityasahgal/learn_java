import java.util.*;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Practice {

    static Map<Integer, User> userCache = new HashMap<>();

    public static void main(String[] args) {

        // Add users
        userCache.put(1, new User(1, "Aditya"));
        userCache.put(2, new User(2, "Rahul"));
        userCache.put(3, new User(3, "Sahgal"));

        // Get user
        User u = userCache.get(2);
        System.out.println("Found: " + u.name);

        // Update user
        userCache.put(2, new User(2, "Updated Rahul"));

        // Remove user
        userCache.remove(1);

        // Print all users
        for (Map.Entry<Integer, User> entry : userCache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().name);
        }
    }
}
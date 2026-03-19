import java.util.*;

public class Basic {
    public static void main(String[] args) {

        Map<Integer, String> users = new HashMap<>();

        users.put(1, "Aditya");
        users.put(2, "Rahul");
        users.put(3, "Sahgal");

        System.out.println(users);

        // Get value
        System.out.println(users.get(2));

        // Remove
        users.remove(1);

        System.out.println(users);

        for (Map.Entry<Integer, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
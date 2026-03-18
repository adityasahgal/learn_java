import java.util.*;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User(1, "Aditya"));
        users.add(new User(2, "Abhishek"));
        users.add(new User(3, "Sahgal"));
        users.add(new User(4, "Anjali"));
        users.add(new User(5, "Shivam"));
        users.add(new User(6, "Rahul"));
        users.add(new User(7, "Kajal"));
        users.add(new User(8, "Mehak"));

        for (User u : users) {
            System.out.println(u.id + " " + u.name);
        }

        // user find by Id
        // for (User u : users) {
        // if (u.id == 1) {
        // System.out.println("Found: " + u.name);
        // }
        // }

        // remove user
        // users.removeIf(u -> u.id == 8);

        for (User u : users) {
            if (u.id == 3) {
                u.name = "Dogi";
                System.out.println("Updated Name: " + u.name);
            }

        }

        for (User u : users) {
            System.out.println(u.id + " " + u.name);
        }

    }
}
import java.util.*;
import java.util.stream.*;

class User {
    int id;
    String name;
    int age;

    User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "Aditya", 22),
                new User(2, "Rahul", 17),
                new User(3, "Sahgal", 25));

        // Adults (filter)
        List<User> adults = users.stream()
                .filter(u -> u.age > 18)
                .collect(Collectors.toList());

        // Names only (map)
        List<String> names = users.stream()
                .map(u -> u.name)
                .collect(Collectors.toList());

        System.out.println("Adults:");
        adults.forEach(u -> System.out.println(u.name));

        System.out.println("Names:");
        names.forEach(System.out::println);
    }
}
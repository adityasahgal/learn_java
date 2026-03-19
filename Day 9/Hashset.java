import java.util.*;

public class Hashset {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        names.add("Aditya");
        names.add("Rahul");
        names.add("Aditya"); // duplicate

        System.out.println(names);
    }
}
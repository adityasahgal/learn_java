import java.util.*;

public class Lambda {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Aditya", "Rahul", "Sahgal");

        names.forEach(name -> System.out.println(name));
    }
}
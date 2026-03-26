class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class UserService {

    User getUser(int id) {

        if (id == 1)
            return new User(1, "Vishal");

        throw new RuntimeException("User not found");
    }
}

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        // Test 1: Success case
        try {
            User user = service.getUser(1);

            if (user.name.equals("Aditya")) {
                System.out.println("Test 1 Passed ✅");
            } else {
                System.out.println("Test 1 Failed ❌");
            }

        } catch (Exception e) {
            System.out.println("Test 1 Failed ❌");
        }

        // Test 2: Exception case
        try {
            service.getUser(2);
            System.out.println("Test 2 Failed ❌");

        } catch (Exception e) {
            System.out.println("Test 2 Passed ✅");
        }
    }
}
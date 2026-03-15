class User {

    int id;
    String username;
    String email;

    User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    void showUser() {
        System.out.println("User ID: " + id);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }
}

public class Practice2 {
    public static void main(String[] args) {

        User u1 = new User(1, "sahgal01", "adityasahagal399@gmail.com");
        u1.showUser();
    }
}
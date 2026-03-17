class User {

    private String name;
    private int age;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }
}

public class Encapsulation {
    public static void main(String[] args) {

        User u = new User();
        u.setName("Sahgal");
        u.setAge(25);

        System.out.println(u.getName());
        System.out.println(u.getAge());
    }
}
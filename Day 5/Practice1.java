class Student {

    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

public class Practice1 {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Aditya", "Java");
        Student s2 = new Student(102, "Rahul", "Spring Boot");

        s1.display();
        System.out.println("------");
        s2.display();
    }
}
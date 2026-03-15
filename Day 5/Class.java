class Student {

    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Class {
    public static void main(String[] args) {

        Student s1 = new Student();

        s1.name = " Aditya Sahgal";
        s1.age = 23;

        s1.display();
    }
}
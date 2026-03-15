class Student {

    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void show() {
        System.out.println(name + " " + age);
    }
}

public class Cunstructor {
    public static void main(String[] args) {

        Student s1 = new Student("Sahgal", 24);
        s1.show();
    }
}
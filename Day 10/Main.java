import java.util.*;

class StudentNotFoundException extends Exception {
    StudentNotFoundException(String message) {
        super(message);
    }
}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentService {

    List<Student> students = new ArrayList<>();

    // Add student
    void addStudent(Student s) {
        students.add(s);
    }

    // Get student by ID
    Student getStudent(int id) throws StudentNotFoundException {

        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }

        throw new StudentNotFoundException("Student not found with ID: " + id);
    }

    // Delete student
    void deleteStudent(int id) throws StudentNotFoundException {

        boolean found = false;

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                found = true;
                break;
            }
        }

        if (!found) {
            throw new StudentNotFoundException("Cannot delete. Student not found!");
        }
    }

    // Display all students
    void displayAll() {
        for (Student s : students) {
            System.out.println(s.id + " " + s.name);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        service.addStudent(new Student(id, name));
                        System.out.println("Student added!");
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        int searchId = sc.nextInt();

                        Student s = service.getStudent(searchId);
                        System.out.println("Found: " + s.name);
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        int delId = sc.nextInt();

                        service.deleteStudent(delId);
                        System.out.println("Deleted!");
                        break;

                    case 4:
                        service.displayAll();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            } finally {
                System.out.println("Operation completed.");
            }
        }
    }
}
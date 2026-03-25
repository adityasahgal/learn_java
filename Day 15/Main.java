import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentNotFoundException extends Exception {
    StudentNotFoundException(String msg) {
        super(msg);
    }
}

class FileService {

    private final String FILE = "students.txt";

    // ADD
    void addStudent(Student s) throws IOException {
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(s.id + "," + s.name + "\n");
        }
    }

    // READ ALL
    List<Student> getAllStudents() throws IOException {
        List<Student> list = new ArrayList<>();

        File file = new File(FILE);
        if (!file.exists())
            return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                list.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1]));
            }
        }
        return list;
    }

    // SEARCH
    Student getStudent(int id) throws Exception {
        for (Student s : getAllStudents()) {
            if (s.id == id)
                return s;
        }
        throw new StudentNotFoundException("Student not found");
    }

    // UPDATE
    void updateStudent(int id, String newName) throws Exception {
        List<Student> list = getAllStudents();
        boolean found = false;

        for (Student s : list) {
            if (s.id == id) {
                s.name = newName;
                found = true;
            }
        }

        if (!found)
            throw new StudentNotFoundException("Update failed");

        writeAll(list);
    }

    // DELETE
    void deleteStudent(int id) throws Exception {
        List<Student> list = getAllStudents();

        boolean removed = list.removeIf(s -> s.id == id);

        if (!removed)
            throw new StudentNotFoundException("Delete failed");

        writeAll(list);
    }

    // WRITE ALL (Helper)
    void writeAll(List<Student> list) throws IOException {
        try (FileWriter fw = new FileWriter(FILE)) {
            for (Student s : list) {
                fw.write(s.id + "," + s.name + "\n");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileService service = new FileService();

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        service.addStudent(new Student(id, name));
                        System.out.println("Added!");
                        break;

                    case 2:
                        service.getAllStudents()
                                .forEach(s -> System.out.println(s.id + " " + s.name));
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int sid = sc.nextInt();

                        Student s = service.getStudent(sid);
                        System.out.println("Found: " + s.name);
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String newName = sc.nextLine();

                        service.updateStudent(uid, newName);
                        System.out.println("Updated!");
                        break;

                    case 5:
                        System.out.print("ID: ");
                        int did = sc.nextInt();

                        service.deleteStudent(did);
                        System.out.println("Deleted!");
                        break;

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
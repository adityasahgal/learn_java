import java.io.*;
import java.util.Scanner;
// import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class FileService {

    private final String FILE_NAME = "students.txt";

    // CREATE (Write)
    void addStudent(Student s) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(s.id + "," + s.name + "\n");
            System.out.println("Student saved to file!");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    // READ (All)
    void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] + " Name: " + data[1]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // SEARCH
    void searchStudent(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {
                    System.out.println("Found: " + data[1]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student not found!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // DELETE
    void deleteStudent(int id) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter fw = new FileWriter(tempFile)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) != id) {
                    fw.write(line + "\n");
                }
            }

            System.out.println("Delete operation completed");

        } catch (IOException e) {
            System.out.println("Error deleting student");
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileService service = new FileService();

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    service.addStudent(new Student(id, name));
                    break;

                case 2:
                    service.readAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    service.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int delId = sc.nextInt();
                    service.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
import java.io.*;
import java.util.*;

class Task {
    int id;
    String title;
    boolean completed;

    Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + completed;
    }
}

class TodoService {

    private final String FILE = "todo.txt";

    // Load tasks from file
    List<Task> loadTasks() throws IOException {
        List<Task> list = new ArrayList<>();
        File file = new File(FILE);

        if (!file.exists())
            return list;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Task(
                    Integer.parseInt(data[0]),
                    data[1],
                    Boolean.parseBoolean(data[2])));
        }
        br.close();
        return list;
    }

    // Save all tasks
    void saveTasks(List<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILE);

        for (Task t : tasks) {
            fw.write(t.toString() + "\n");
        }

        fw.close();
    }

    // Add task
    void addTask(String title) throws IOException {
        List<Task> tasks = loadTasks();
        int id = tasks.size() + 1;

        tasks.add(new Task(id, title, false));
        saveTasks(tasks);

        System.out.println("Task added ✅");
    }

    // View tasks
    void viewTasks() throws IOException {
        List<Task> tasks = loadTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found ❌");
            return;
        }

        for (Task t : tasks) {
            String status = t.completed ? "✔" : "❌";
            System.out.println(t.id + ". " + t.title + " [" + status + "]");
        }
    }

    // Mark complete
    void markComplete(int id) throws IOException {
        List<Task> tasks = loadTasks();

        for (Task t : tasks) {
            if (t.id == id) {
                t.completed = true;
            }
        }

        saveTasks(tasks);
        System.out.println("Task completed ✅");
    }

    // Delete task
    void deleteTask(int id) throws IOException {
        List<Task> tasks = loadTasks();

        tasks.removeIf(t -> t.id == id);

        saveTasks(tasks);
        System.out.println("Task deleted 🗑️");
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        TodoService service = new TodoService();

        while (true) {

            System.out.println("\n==== TODO APP ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String title = sc.nextLine();
                    service.addTask(title);
                    break;

                case 2:
                    service.viewTasks();
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int cid = sc.nextInt();
                    service.markComplete(cid);
                    break;

                case 4:
                    System.out.print("Enter task ID: ");
                    int did = sc.nextInt();
                    service.deleteTask(did);
                    break;

                case 5:
                    System.out.println("Bye 👋");
                    return;

                default:
                    System.out.println("Invalid option ❌");
            }
        }
    }
}
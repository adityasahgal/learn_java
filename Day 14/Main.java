// class MyThread extends Thread {
//     public void run() {
//         System.out.println("Thread running...");
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         MyThread t1 = new MyThread();
//         t1.start();
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         Thread t1 = new Thread(() -> {
//             System.out.println("Lambda thread running...");
//         });

//         t1.start();
//     }
// }

// import java.util.concurrent.*;

// public class Main {
//     public static void main(String[] args) {

//         ExecutorService executor = Executors.newFixedThreadPool(3);

//         for (int i = 1; i <= 5; i++) {
//             int taskId = i;

//             executor.execute(() -> {
//                 System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
//             });
//         }

//         executor.shutdown();
//     }
// }

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            System.out.println("Calling User API...");
        });

        executor.execute(() -> {
            System.out.println("Calling Order API...");
        });

        executor.execute(() -> {
            System.out.println("Processing Payment...");
        });

        executor.shutdown();
    }
}
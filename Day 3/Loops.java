import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i = 0;

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // FOR LOOP

        // for (int i = 1; i <= num; i++) {
        // System.out.println("Number: " + i);
        // }

        // WHILE LOOP

        while (i <= num) {
            System.out.println("Number: " + i);
            i++;
        }

    }
}
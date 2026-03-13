import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number: ");
        int first = sc.nextInt();

        if (first > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }

    }
}

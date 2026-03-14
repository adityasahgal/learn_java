public class Largest {

    static int findLargest(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) {

        int result = findLargest(10, 25);
        System.out.println("Largest: " + result);

    }
}
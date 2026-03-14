public class Square {

    static int square(int num) {
        return num * num;
    }

    static int square2(int num) {
        return num * num;
    }

    public static void main(String[] args) {

        int result = square(6);
        System.out.println("Square: " + result);

        int result2 = square2(12);
        System.out.println("Square2: " + result2);

    }
}
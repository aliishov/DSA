package recursion;

public class Main {

    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("One");
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}

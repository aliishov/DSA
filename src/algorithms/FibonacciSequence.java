package algorithms;

public class FibonacciSequence {
    static int counter1 = 0;
    static int counter2 = 0;
    static int counter3 = 0;
    static Integer[] memo = new Integer[100];

    public static int fib1(int n) {
        counter1++;
        if (n <= 1) return n;
        return fib1(n-1) + fib1(n-2);
    }

    public static int fib2(int n) {
        counter2++;
        if (memo[n] != null) return memo[n];
        if (n <= 1) return n;
        memo[n] = fib2(n-1) + fib2(n-2);
        return memo[n];
    }

    public static  int fib3(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i = 2; i <= n; i++) {
            counter3++;
            fibList[i] = fibList[i-1] + fibList[i-2];
        }
        return fibList[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Number: " + fib1(40));
        System.out.println("Fibonacci Counter: " + counter1 + "\n");

        System.out.println("Fibonacci Memo Number: " +fib2(40));
        System.out.println("Fibonacci Memo Counter: " + counter2 + "\n");

        System.out.println("Fibonacci Iteratively Number: " +fib3(40));
        System.out.println("Fibonacci Iteratively Counter: " + counter3 + "\n");
    }
}

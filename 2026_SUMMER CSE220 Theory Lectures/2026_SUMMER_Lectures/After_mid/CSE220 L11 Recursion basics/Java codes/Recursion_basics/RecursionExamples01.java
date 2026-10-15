public class RecursionExamples01 {

    // Example 01: Printing 1 to 4 using while loop
    public static void show1to4While() {
        int i = 1;
        while (i <= 4) {
            System.out.println(i);
            i++;
        }
    }
    
    // Example 01: Printing 1 to 4
    public static void show1to4(int i) {
        if (i > 4) {
            return;
        } else {
            System.out.println(i);
            show1to4(i + 1);
        }
    }
    
    // Example 02: Printing 4 to 1 using while loop
    public static void show4to1While() {
        int i = 4;
        while (i > 0) {
            System.out.println(i);
            i--;
        }
    }    

    // Example 02: Printing 4 to 1
    public static void show4to1(int i) {
        if (i == 0) {
            return;
        } else {
            System.out.println(i);
            show4to1(i - 1);
        }
    }

    public static void show4to1ReverseOrder(int i) {
        if (i > 4) {
            return;
        } else {
            show4to1ReverseOrder(i + 1);
            System.out.println(i);
        }
    }
    
    // Example 03: Summation from 1 to N using while loop
    public static int sum1toNWhile( int n) {
        int sum = 0;
        int i=1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    // Example 03: Summation from 1 to N using Recursion
    public static int sum1toN(int i, int n) {
        if (i == n) {
            return n;
        } else {
            return i + sum1toN(i + 1, n);
        }
    }

    // Example 04: Factorial using loop
    public static int factLoop(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n -= 1;
        }
        return result;
    }

    // Example 04: Factorial using recursion
    public static int factRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factRec(n - 1);
        }
    }

    // Example 05: Fibonacci using loop
    public static int getNthFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n > 1) {
            int n1 = 0, n2 = 1, fib_sum = 0;
            for (int i = 2; i <= n; i++) {
                fib_sum = n1 + n2;
                n1 = n2;
                n2 = fib_sum;
            }
            return n2;
        } else return -1;
    }

    // Example 05: Fibonacci using recursion
    public static int getNthFibonacciRecursive(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return getNthFibonacciRecursive(n - 1) + getNthFibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {

    // Example 01: Printing 1 to 4
    System.out.println("Example 01: Print 1 to 4");
    System.out.println("Using Loop:");
    show1to4While();
    System.out.println("Using Recursion:");
    show1to4(1);
    System.out.println();

    // Example 02: Print 4 to 1
    System.out.println("Example 02: Print 4 to 1");
    System.out.println("Using Loop:");
    show4to1While();
    System.out.println("Using Recursion:");
    show4to1(4);
    System.out.println("Using Recursion (Reverse Order):");
    show4to1ReverseOrder(1);
    System.out.println();

    // Example 03: Summation from 1 to N
    int N = 5;
    System.out.println("Example 03: Summation 1 to " + N);
    System.out.println("Using Loop:");
    System.out.println(sum1toNWhile(N));
    System.out.println("Using Recursion:");
    System.out.println(sum1toN(1, N));
    System.out.println();

    // Example 04: Factorial
    int factInput = 4;
    System.out.println("Example 04: Factorial of " + factInput);
    System.out.println("Using Loop:");
    System.out.println(factLoop(factInput));
    System.out.println("Using Recursion:");
    System.out.println(factRec(factInput));
    System.out.println();

    // Example 05: Fibonacci
    int[] fibInputs = {4, 6, 8};
    System.out.println("Example 05: Fibonacci");
    System.out.println("Using Loop:");
    for (int i = 0; i < fibInputs.length; i++) {
        int n = fibInputs[i];
        System.out.println(n + "th Fibonacci number: " + getNthFibonacci(n));
    }

    System.out.println("Using Recursion:");
    for (int i = 0; i < fibInputs.length; i++) {
        int n = fibInputs[i];
        System.out.println(n + "th Fibonacci number: " + getNthFibonacciRecursive(n));
    }
  }
}

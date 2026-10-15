public class RecursionExamples02Arrays {

    // Example 06: Forward printing using while loop
    public static void printArrayForwardWhile(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
        System.out.println();
    }

    // Example 06: FW printing of array elements
    public static void arrForwardPrinting(int i, int[] arr) {
        if (i == arr.length) return;
        else {
            System.out.print(arr[i] + " ");
            arrForwardPrinting(i + 1, arr);
        }
    }

    // Example 07: Backward printing using while loop
    public static void printArrayBackwardWhile(int[] arr) {
        int i = arr.length - 1;
        while (i >= 0) {
            System.out.print(arr[i] + " ");
            i--;
        }
        System.out.println();
    }

    // Example 07: Backward printing using recursion
    public static void printArrayBackwardRec(int i, int[] arr) {
        if (i < 0) {
            return;
        } else {
            System.out.print(arr[i] + " ");
            printArrayBackwardRec(i - 1, arr);
        }
    }

    // Example 07: BW printing of array elements (order changed)
    public static void arrBkPrintOrderChange(int i, int[] arr) {
        if (i == arr.length) return;
        else {
            arrBkPrintOrderChange(i + 1, arr);
            System.out.print(arr[i] + " ");
        }
    }

    // Example 08: Summation of array elements - ITERATIVE
    public static int arrSumIterative(int[] arr) {
        int total = 0;
        int i = 0;
        while (i < arr.length) {
            total += arr[i];
            i++;
        }
        return total;
    }

    // Example 08: Recursive sum using index
    public static int arrSum(int i, int[] arr) {
        if (i == arr.length - 1) {
            return arr[i];
        } else {
            return arr[i] + arrSum(i + 1, arr);
        }
    }

    // Example 08: Recursive sum with extra prints
    public static int arrSumWithPrint(int i, int[] arr) {
        if (i == arr.length - 1) {
            System.out.print(arr[i] + "=");
            return arr[i];
        } else {
            System.out.print(arr[i] + "+");
            return arr[i] + arrSumWithPrint(i + 1, arr);
        }
    }

    // Example 08:  Recursive method to compute sum of array elements
    public static int arrSum_type2(int i, int[] arr) {
        // Base case: when index reaches the array length
        if (i == arr.length) {
            return 0;
        }
        // Recursive case
        return arr[i] + arrSum_type2(i + 1, arr);
    }

    // Example 09: Multiplication of array elements - ITERATIVE
    public static int arrMulIterative(int[] arr) {
        int mulAns = 1;
        int i = 0;
        while (i < arr.length) {
            mulAns *= arr[i];
            i++;
        }
        return mulAns;
    }

    // Example 09: Recursive multiplication using index
    public static int arrMul(int i, int[] arr) {
        if (i == arr.length - 1) {
            return arr[i];
        } else {
            return arr[i] * arrMul(i + 1, arr);
        }
    }

    // Example 09: Recursive multiplication with extra prints
    public static int arrMulWithPrint(int i, int[] arr) {
        if (i == arr.length - 1) {
            System.out.print(arr[i] + "=");
            return arr[i];
        } else {
            System.out.print(arr[i] + "x");
            return arr[i] * arrMulWithPrint(i + 1, arr);
        }
    }

    // Example 09:  Recursive method to compute multiplication of array elements
    public static int arrMul_typ2(int i, int[] arr) {
        // Base case: when index reaches array length
        if (i == arr.length) {
            return 1;   // Multiplicative identity
        }
        // Recursive case
        return arr[i] * arrMul_typ2(i + 1, arr);
    }

    // Example 10: Weird sum: add even, subtract odd (while-loop version)
    public static int arrWeirdSumWhile(int[] arr) {
        int i = 0;
        int total = 0;

        while (i < arr.length) {
            total += evenOdd(arr[i]);
            i++;
        }

        return total;
    }

    // Helper: returns +n for even, -n for odd, and prints the sign
    public static int evenOdd(int n) {
        if (n % 2 == 1) {
            return -n;
        } else {
            return n;
        }
    }

    // Example 10: Weird sum: add even, subtract odd (recursion)
    public static int arrWeirdSum(int i, int[] arr) {
        if (i == arr.length - 1) {
            return evenOdd(arr[i]);
        } else {
            return evenOdd(arr[i]) + arrWeirdSum(i + 1, arr);
        }
    }



    public static void main(String[] args) {
        int[] arr1D = {12, 44, 6, 57, 69, 87, 5, 3};

        // Example 06
        System.out.println("Example 06: FW Printing (while loop)");
        printArrayForwardWhile(arr1D);

        System.out.println("Example 06: FW Printing (recursion)");
        arrForwardPrinting(0, arr1D);
        System.out.println();

        // Example 07
        System.out.println("Example 07: BW Printing (while loop)");
        printArrayBackwardWhile(arr1D);

        System.out.println("Example 07: BW Printing (recursion)");
        printArrayBackwardRec(arr1D.length - 1, arr1D);
        System.out.println();

        System.out.println("Example 07: BW Printing (order changed recursion)");
        arrBkPrintOrderChange(0, arr1D);
        System.out.println();

        // Example 08
        int[] arrSum1 = {1, 2, 10, 20};
        System.out.println("Example 08: Sum (while loop)\n" + arrSumIterative(arrSum1));

        int[] arrSum3 = {1, 4, 6, 5, 9, 3};
        System.out.println("Example 08: Sum (recursion with index)\n" + arrSum(0, arrSum3));

        int[] arrSum4 = {1, 4, 6, 5, 9, 3};
        System.out.print("Example 08: Sum (recursion with prints)\n");
        int sum = arrSumWithPrint(0, arrSum4);
        System.out.println(sum);

        int[] arrSum5 = {1, 4, 6, 5, 9, 3};
        System.out.println("Example 08: Sum (recursion type2)\n" + arrSum_type2(0, arrSum5));

        // Example 09
        int[] arrMul1 = {3, 4, 6, 2};
        System.out.println("Example 09: Multiplication (while loop)\n" + arrMulIterative(arrMul1));

        System.out.println("Example 09: Multiplication (recursion)\n" + arrMul(0, arrMul1));

        System.out.print("Example 09: Multiplication (recursion with prints)\n");
        int mul = arrMulWithPrint(0, arrMul1);
        System.out.println(mul);

        System.out.println("Example 09: Multiplication (recursion type2)\n" + arrMul_typ2(0, arrMul1));

        // Example 10
        int[] weirdArr = {10, 4, 5, 9, 2};

        System.out.print("Example 10: Weird sum While\n");
        int result = arrWeirdSumWhile(weirdArr);   // prints +10+4-5-9+2
        System.out.println("=" + result);          // prints =<sum>

        System.out.print("Example 10: Weird sum recursion\n");
        int weirdSum = arrWeirdSum(0, weirdArr);   // prints +10+4-5-9+2
        System.out.println("=" + weirdSum);        // prints =<sum>
    }
}

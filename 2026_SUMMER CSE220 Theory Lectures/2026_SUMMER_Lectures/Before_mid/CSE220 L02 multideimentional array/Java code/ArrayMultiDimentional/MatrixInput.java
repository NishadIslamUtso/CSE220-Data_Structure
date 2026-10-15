import java.util.Scanner;

public class MatrixInput {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;
        int[][] matrix = new int[rows][cols]; // Initializes with zeros by default

        Scanner scanner = new Scanner(System.in);

        System.out.println("Printing the empty matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Take user input to fill the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value for element at position (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The resulting matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

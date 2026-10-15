public class RotateMatrixMinus90 {

    // Method to rotate a matrix by -90 degrees (90 degrees counter-clockwise)
    public static int[][] rotateMinus90(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Reverse each row
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        // Step 2: Transpose the matrix
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {           // loop through rows
            for (int j = 0; j < matrix[i].length; j++) {    // loop through columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // Main method to test
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix1);
        int[][] rotated1 = rotateMinus90(matrix1);
        System.out.println("Rotated matrix:");
        printMatrix(rotated1);

        int[][] matrix2 = {
            {1, 2, 3},
            {5, 6, 7},
            {9, 10, 11}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix2);
        int[][] rotated2 = rotateMinus90(matrix2);
        System.out.println("Rotated matrix:");
        printMatrix(rotated2);
    }
}

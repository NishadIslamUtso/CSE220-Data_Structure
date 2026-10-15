import java.util.Arrays;
public class ArrayMultiDimensionalTester {

    public static void main(String[] args) {

        // Example 1
        int[][] matrix = {
            {4, 3, 8},
            {2, 5, 1},
            {7, -1, 9},
            {5, 4, -2}
        };
        ArrayMultiDimensional arrayOperations = new ArrayMultiDimensional(matrix);

        System.out.println("Row-wise elements:");
        arrayOperations.printRowWiseElem();

        System.out.println("Column-wise elements:");
        arrayOperations.printColWiseElem();

        System.out.println("Array sum: " + arrayOperations.getArraySum());

        System.out.println("Row-wise sum:"); 
        int[][] result = arrayOperations.getRowWiseArraySum(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + " ");
        }
        System.out.println();
        

        System.out.println("Column-wise sum:");
        // Call the method to get column-wise sum
        int[][] result2 = arrayOperations.getColWiseArraySum(matrix);

        for (int i = 0; i < result2[0].length; i++) {
            System.out.print(result2[0][i] + " ");
        }
        System.out.println(); // Move to the next line after printing

        // Example 2
        int[][] squareMatrix = {
            {4, 3, 8},
            {2, 5, 1},
            {7, -1, 9}
        };
        arrayOperations = new ArrayMultiDimensional(squareMatrix);

        System.out.println("Primary diagonal sum: " + arrayOperations.getPrimaryDiagonalSum());
        System.out.println("Secondary diagonal sum: " + arrayOperations.getSecondaryDiagonalSum());

        // Example 3
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] addedMatrix = arrayOperations.addMatrices(matrix2);
        System.out.println("Sum of matrices:");
        for (int i = 0; i < addedMatrix.length; i++) {
            for (int j = 0; j < addedMatrix[i].length; j++) {
                System.out.print(addedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Example 4
        int[][] swappedMatrix = arrayOperations.swapColumns(matrix);

        // Print the swapped matrix
        System.out.println("Swapped Matrix1:");
        for (int i = 0; i < swappedMatrix.length; i++) {
            for (int j = 0; j < swappedMatrix[i].length; j++) {
                System.out.print(swappedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        int[][] matrix22 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        int[][] swappedMatrix2 = arrayOperations.swapColumns(matrix22);
        
        System.out.println("Swapped Matrix2:");
        for (int i = 0; i < swappedMatrix2.length; i++) {
            for (int j = 0; j < swappedMatrix2[i].length; j++) {
                System.out.print(swappedMatrix2[i][j] + " ");
            }
            System.out.println();
        }

        // Example 5
        int[][] scalarMatrix = arrayOperations.multiplyMatrixByScalar(2);
        System.out.println("Matrix after multiplying by scalar 2:");
        for (int i = 0; i < scalarMatrix.length; i++) {
            for (int j = 0; j < scalarMatrix[i].length; j++) {
                System.out.print(scalarMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Example 6
        int[][] matrix3 = {
            {1, -2, 1},
            {2, -1, 2},
            {3, 3, 1}
        };
        int[][] multipliedMatrix = arrayOperations.multiplyMatrixByMatrix(matrix3);
        System.out.println("Matrix after multiplying by another matrix:");
        for (int i = 0; i < multipliedMatrix.length; i++) {
            for (int j = 0; j < multipliedMatrix[i].length; j++) {
                System.out.print(multipliedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
// Example 1: 3x3 matrix
        int[][] matrix4 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print the original matrix (3x3)
        System.out.println("Original matrix (3x3):");
        for (int i = 0; i < matrix4.length; i++) {
            for (int j = 0; j < matrix4[i].length; j++) {
                System.out.print(matrix4[i][j] + " | ");
            }
            System.out.println();
        }

        int[][] transposedMatrix1 = arrayOperations.transpose(matrix4);
        System.out.println("Transposed matrix (3x3):");
        for (int i = 0; i < transposedMatrix1.length; i++) {
            for (int j = 0; j < transposedMatrix1[i].length; j++) {
                System.out.print(transposedMatrix1[i][j] + " | ");
            }
            System.out.println();
        }

        // Example 2: 4x4 matrix
        int[][] matrix5 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Print the original matrix (4x4)
        System.out.println("Original matrix (4x4):");
        for (int i = 0; i < matrix5.length; i++) {
            for (int j = 0; j < matrix5[i].length; j++) {
                System.out.print(matrix5[i][j] + " | ");
            }
            System.out.println();
        }

        int[][] transposedMatrix2 = arrayOperations.transpose(matrix5);
        System.out.println("Transposed matrix (4x4):");
        for (int i = 0; i < transposedMatrix2.length; i++) {
            for (int j = 0; j < transposedMatrix2[i].length; j++) {
                System.out.print(transposedMatrix2[i][j] + " | ");
            }
            System.out.println();
        }        
        

    }
}

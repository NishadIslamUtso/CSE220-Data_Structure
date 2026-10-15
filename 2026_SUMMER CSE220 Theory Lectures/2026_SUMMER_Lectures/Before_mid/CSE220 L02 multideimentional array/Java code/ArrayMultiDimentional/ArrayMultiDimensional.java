public class ArrayMultiDimensional {

    public int[][] matrix;

    public ArrayMultiDimensional(int[][] matrix) {
        this.matrix = matrix;
    }

    public void printRowWiseElem() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int rowNo = 0; rowNo < rows; rowNo++) {
            for (int colNo = 0; colNo < cols; colNo++) {
                System.out.print(matrix[rowNo][colNo] + " ");
            }
            System.out.println("\n-----------------");
        }
    }

    public void printColWiseElem() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int colNo = 0; colNo < cols; colNo++) {
            for (int rowNo = 0; rowNo < rows; rowNo++) {
                System.out.print(matrix[rowNo][colNo] + " ");
            }
            System.out.println("\n-----------------");
        }
    }

    public int getArraySum() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sumResult = 0;
        for (int rowNo = 0; rowNo < rows; rowNo++) {
            for (int colNo = 0; colNo < cols; colNo++) {
                sumResult += matrix[rowNo][colNo];
            }
        }
        return sumResult;
    }

    public int[][] getRowWiseArraySum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] sumResult = new int[rows][1];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sumResult[row][0] += matrix[row][col];
            }
        }
        return sumResult;
    }

    public int[][] getColWiseArraySum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] sumResult = new int[1][cols];

        for (int colNo = 0; colNo < cols; colNo++) {
            for (int rowNo = 0; rowNo < rows; rowNo++) {
                sumResult[0][colNo] += matrix[rowNo][colNo];
            }
        }
        return sumResult;
    }
    

    public Integer getPrimaryDiagonalSum() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            System.out.println("Not a square matrix, does not have diagonal values");
            return null;
        }
        int sumResult = 0;
        for (int rowNo = 0; rowNo < rows; rowNo++) {
            sumResult += matrix[rowNo][rowNo];
        }
        return sumResult;
    }

    public Integer getSecondaryDiagonalSum() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
         System.out.println("Not a square matrix, does not have diagonal values");
         return null;
        }
        int sumResult = 0;
        for (int rowNo = 0; rowNo < rows; rowNo++) {
            sumResult += matrix[rowNo][cols - 1 - rowNo];
        }
        return sumResult;
    }

    public int[][] addMatrices(int[][] matrix2) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix2.length != rows || matrix2[0].length != cols) {
            System.out.println("Dimension mismatch: Matrices must have the same dimensions");
            return null;
        }
        int[][] result = new int[rows][cols];
        for (int rowNo = 0; rowNo < rows; rowNo++) {
            for (int colNo = 0; colNo < cols; colNo++) {
                result[rowNo][colNo] = matrix[rowNo][colNo] + matrix2[rowNo][colNo];
            }
        }
        return result;
    }

    // Method to swap columns in a matrix
    public int[][] swapColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a copy of the matrix
        int[][] matrixCopy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, cols);
        }

        for (int rowNo = 0; rowNo < rows; rowNo++) {
            for (int colNoFromStart = 0; colNoFromStart < cols / 2; colNoFromStart++) {
                int colNoFromEnd = cols - colNoFromStart - 1; // Get the index of the last column

                // Swap the column values
                int temp = matrixCopy[rowNo][colNoFromStart];  
                matrixCopy[rowNo][colNoFromStart] = matrixCopy[rowNo][colNoFromEnd]; 
                matrixCopy[rowNo][colNoFromEnd] = temp;
            }
        }

        return matrixCopy;
    }

    public int[][] multiplyMatrixByScalar(int scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int rowNo = 0; rowNo < rows; rowNo++) {
            for (int colNo = 0; colNo < cols; colNo++) {
                result[rowNo][colNo] = matrix[rowNo][colNo] * scalar;
            }
        }
        return result;
    }

    public int[][] multiplyMatrixByMatrix(int[][] matrix2) {
        int rows1 = matrix.length;
        int cols1 = matrix[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        if (cols1 != rows2) {
            System.out.println("Cannot multiply: Incompatible dimensions");
            return null;
        }
        int[][] result = new int[rows1][cols2];
        for (int rowNo = 0; rowNo < rows1; rowNo++) {
            for (int colNo = 0; colNo < cols2; colNo++) {
                for (int k = 0; k < cols1; k++) {
                    result[rowNo][colNo] += matrix[rowNo][k] * matrix2[k][colNo];
                }
            }
        }
        return result;
    }
    
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;         // Number of rows
        int cols = matrix[0].length;      // Number of columns

        // Create an empty matrix for the transpose with transposed dimensions
        int[][] transposed = new int[cols][rows];

        // Iterate through each element and transpose it
        for (int rowNo = 0; rowNo < rows; rowNo++) {         // Iterate through rows of the original matrix
            for (int colNo = 0; colNo < cols; colNo++) {     // Iterate through columns of the original matrix
                transposed[colNo][rowNo] = matrix[rowNo][colNo];  // Swap rows and columns
            }
        }

        return transposed;
    }
}
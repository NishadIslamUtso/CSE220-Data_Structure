class Q1_array {

    public static void decode1(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int row_no = 0; row_no < row - 1; row_no++) {
            for (int col_no = 0; col_no < col; col_no += 2) {

                if (matrix[row_no][col_no] != '#') {
                    System.out.print(matrix[row_no][col_no]);
                    matrix[row_no][col_no] = '#';
                }

                if (matrix[row_no + 1][col_no + 1] != '#') {
                    System.out.print(matrix[row_no + 1][col_no + 1]);
                    matrix[row_no + 1][col_no + 1] = '#';
                }

                if (matrix[row_no][col_no + 1] != '#') {
                    System.out.print(matrix[row_no][col_no + 1]);
                    matrix[row_no][col_no + 1] = '#';
                }

                if (matrix[row_no + 1][col_no] != '#') {
                    System.out.print(matrix[row_no + 1][col_no]);
                    matrix[row_no + 1][col_no] = '#';
                }
            }
        }
        System.out.println();
    }

    ////////////////////////////////////////////////////////
    public static void decode2(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row_no = 0; row_no < rows - 1; row_no++) {
            for (int col_no = 0; col_no < cols; col_no += 2) {

                int[][] order = {
                    {row_no, col_no},
                    {row_no + 1, col_no + 1},
                    {row_no, col_no + 1},
                    {row_no + 1, col_no}
                };

                for (int i = 0; i < order.length; i++) {
                    int x = order[i][0];
                    int y = order[i][1];

                    if (matrix[x][y] != '#') {
                        System.out.print(matrix[x][y]);
                        matrix[x][y] = '#';
                    }
                }
            }
        }
        System.out.println();
    }

    ////////////////////////////////////////////////////////
    public static void printIfNotVisited(char[][] matrix, int i, int j) {
        if (matrix[i][j] != '#') {
            System.out.print(matrix[i][j]);
            matrix[i][j] = '#';
        }
    }

    public static void decode3(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row_no = 0; row_no < rows - 1; row_no++) {
            for (int col_no = 0; col_no < cols; col_no += 2) {
                printIfNotVisited(matrix, row_no, col_no);
                printIfNotVisited(matrix, row_no + 1, col_no + 1);
                printIfNotVisited(matrix, row_no, col_no + 1);
                printIfNotVisited(matrix, row_no + 1, col_no);
            }
        }

        System.out.println();
    }

    public static void decode4(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
    
        String result = "";
    
        for (int row_no = 0; row_no < rows; row_no++) {
            if (row_no == rows - 1) {
                break;
            }
    
            for (int col_no = 0; col_no <= cols - 2; col_no += 2) {
    
                if (matrix[row_no][col_no] != '#') {
                    result += matrix[row_no][col_no];
                    matrix[row_no][col_no] = '#';
                }
    
                if (matrix[row_no + 1][col_no + 1] != '#') {
                    result += matrix[row_no + 1][col_no + 1];
                    matrix[row_no + 1][col_no + 1] = '#';
                }
    
                if (matrix[row_no][col_no + 1] != '#') {
                    result += matrix[row_no][col_no + 1];
                    matrix[row_no][col_no + 1] = '#';
                }
    
                if (matrix[row_no + 1][col_no] != '#') {
                    result += matrix[row_no + 1][col_no];
                    matrix[row_no + 1][col_no] = '#';
                }
            }
        }
    
        System.out.println(result);
    }

    ////////////////////////////////////////////////////////
    public static char[][] copyMatrix(char[][] matrix) {
        char[][] newMatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    // -------- DRIVER --------
    public static void main(String[] args) {
        char[][] matrix = {
            {'T', 'A', 'E', 'S', '_', 'H'},
            {'V', 'R', 'E', 'R', 'E', 'T'},
            {'G', '_', 'I', 'R', '!', 'D'}
        };

        char[][] m1 = copyMatrix(matrix);
        char[][] m2 = copyMatrix(matrix);
        char[][] m3 = copyMatrix(matrix);
        char[][] m4 = copyMatrix(matrix);

        decode1(m1);
        System.out.println("=".repeat(50));

        decode2(m2);
        System.out.println("=".repeat(50));

        decode3(m3);
        System.out.println("=".repeat(50));

        decode4(m4);
        System.out.println("=".repeat(50));
    }
}
public class Q1BlockEnergySum {
    // =======================================
    // blockEnergySum1 - inline diagonal logic
    // =======================================
    public static int[][] blockEnergySum1(int[][] grid, String[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] energy = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                String d = directions[row][col];
                int dx = 0, dy = 0;

                if (d.equals("NE")) {
                    dx = -1; dy = 1;
                } else if (d.equals("NW")) {
                    dx = -1; dy = -1;
                } else if (d.equals("SE")) {
                    dx = 1; dy = 1;
                } else if (d.equals("SW")) {
                    dx = 1; dy = -1;
                } else {
                    dx = 0; dy = 0;  // safety fallback
                }

                int r = row;
                int c = col;
                int total = 0;

                while (r >= 0 && r < rows && c >= 0 && c < cols) {
                    total += grid[r][c];
                    r += dx;
                    c += dy;
                }

                energy[row][col] = total;
            }
        }

        return energy;
    }

    // =======================================
    // blockEnergySum2 - uses diagonalSum()
    // =======================================
    public static int[][] blockEnergySum2(int[][] grid, String[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] energy = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                String direction = directions[row][col];
                int dx = 0, dy = 0;

                if (direction.equals("NE")) {
                    dx = -1; dy = 1;
                } else if (direction.equals("NW")) {
                    dx = -1; dy = -1;
                } else if (direction.equals("SE")) {
                    dx = 1; dy = 1;
                } else if (direction.equals("SW")) {
                    dx = 1; dy = -1;
                }

                energy[row][col] = diagonalSum(grid, row, col, dx, dy);
            }
        }

        return energy;
    }

    // =======================================
    // diagonalSum helper
    // =======================================
    public static int diagonalSum(int[][] grid, int startR, int startC, int dx, int dy) {
        int rows = grid.length;
        int cols = grid[0].length;

        int total = 0;
        int r = startR;
        int c = startC;

        while (r >= 0 && r < rows && c >= 0 && c < cols) {
            total += grid[r][c];
            r += dx;
            c += dy;
        }

        return total;
    }

    // =======================================
    // printMatrix 
    // =======================================
    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print("[");
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
                if (c < matrix[r].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    // =======================================
    // DRIVER (main)
    // =======================================
    public static void main(String[] args) {

        int[][] grid = {
            { 1,  2,  3,  4},
            { 5,  6,  7,  8},
            { 9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        String[][] directions = {
            {"SE","SE","SW","NE"},
            {"SW","SW","NE","SE"},
            {"NW","SW","NE","NW"},
            {"SE","NW","SW","NE"}
        };

        System.out.println("Result of blockEnergySum1:");
        int[][] res1 = blockEnergySum1(grid, directions);
        printMatrix(res1);

        System.out.println("\nResult of blockEnergySum2:");
        int[][] res2 = blockEnergySum2(grid, directions);
        printMatrix(res2);
    }
}

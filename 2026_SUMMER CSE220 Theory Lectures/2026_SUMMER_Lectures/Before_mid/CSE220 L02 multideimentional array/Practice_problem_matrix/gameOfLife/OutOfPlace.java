public class OutOfPlace {

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Stores the next generation
        int[][] nextBoard = new int[rows][cols]; // Space complexity MxN

        // Process each cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Count live neighbors around current cell
                int liveNeighbors = countLiveNeighbors(board, row, col);

                if (board[row][col] == 1) {
                    // Live cell survives with 2 or 3 live neighbors
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        nextBoard[row][col] = 1;
                    } else {
                        nextBoard[row][col] = 0;
                    }
                } else {
                    // Dead cell becomes live with exactly 3 live neighbors
                    if (liveNeighbors == 3) {
                        nextBoard[row][col] = 1;
                    } else {
                        nextBoard[row][col] = 0;
                    }
                }
            }
        }

        // Copy nextBoard back to original board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = nextBoard[row][col];
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        // 8 possible directions
        int[][] directions = {
                {-1,  0},  // top
                { 1,  0},  // bottom
                { 0, -1},  // left
                { 0,  1},  // right
                {-1, -1},  // top-left
                {-1,  1},  // top-right
                { 1, -1},  // bottom-left
                { 1,  1}   // bottom-right
        };

        // Check all valid neighbors
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols &&
                board[newRow][newCol] == 1) {
                count++;
            }
        }

        return count;
    }

    public static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print("[");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);

                if (col < board[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        // Sample 1
        int[][] board1 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Input 1:");
        printBoard(board1);

        gameOfLife(board1);

        System.out.println("Output 1:");
        printBoard(board1);


        // Sample 2
        int[][] board2 = {
                {1, 1},
                {1, 0}
        };

        System.out.println("\nInput 2:");
        printBoard(board2);

        gameOfLife(board2);

        System.out.println("Output 2:");
        printBoard(board2);
    }
}
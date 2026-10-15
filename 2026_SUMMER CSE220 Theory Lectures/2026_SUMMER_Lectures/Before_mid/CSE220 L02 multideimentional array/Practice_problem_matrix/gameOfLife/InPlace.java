public class InPlace {

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        /*
         Temporary states:
         1  = live stays live
         0  = dead stays dead
        -1  = live -> dead
         2  = dead -> live
        */

        // First pass: mark changes
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Count originally live neighbors
                int liveNeighbors = countLiveNeighbors(board, row, col);

                // Live cell dies
                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }

                // Dead cell becomes live
                else if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }

        // Second pass: finalize values
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static int countLiveNeighbors(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        // 8 neighbor directions
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

        // Check each valid neighbor
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow >= 0 && newRow < rows &&
                newCol >= 0 && newCol < cols) {

                // 1 and -1 were originally live
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == -1) {
                    count++;
                }
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
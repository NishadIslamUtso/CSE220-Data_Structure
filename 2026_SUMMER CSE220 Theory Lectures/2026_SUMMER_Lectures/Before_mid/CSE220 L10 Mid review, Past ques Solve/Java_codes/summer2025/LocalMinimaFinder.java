// Java implementation of all local minima search methods
public class LocalMinimaFinder {

    // Method 1: With list (stores all valid minima)
    public static int[] localMinimaWithList(int[][] matrix, int threshold) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = {-1, -1, -1};

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int center = matrix[i][j];
                if (center > threshold) continue;

                boolean isLocalMin = true;
                if (matrix[i - 1][j] <= threshold && center >= matrix[i - 1][j]) isLocalMin = false;
                if (matrix[i + 1][j] <= threshold && center >= matrix[i + 1][j]) isLocalMin = false;
                if (matrix[i][j - 1] <= threshold && center >= matrix[i][j - 1]) isLocalMin = false;
                if (matrix[i][j + 1] <= threshold && center >= matrix[i][j + 1]) isLocalMin = false;

                if (isLocalMin) {
                    result = new int[]{i, j, center};
                }
            }
        }
        return result;
    }



    // Driver method to test all
    public static void main(String[] args) {
        int[][] matrix = {
            {22, 21, 1000, 23},
            {25, 17, 21, 1000},
            {1000, 19, 18, 22},
            {21, 22, 1000, 20}
        };
        int threshold = 100;

        System.out.println("-".repeat(80));
        int[] res1 = localMinimaWithList(matrix, threshold);
        System.out.println("With list: (" + res1[0] + ", " + res1[1] + ") value: " + res1[2]);

    }
}

public class ArrayCreation{
    public static void main(String[] args) {
        //Using Direct Initialization 
        int[][] arr1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Using new Keyword
        // Using default value of the data type
        int[][] arr2 = new int[3][3];

        // Printing the 2D array
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("======================");
        

        // Printing the 2D array
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("======================");
        
        // Finding the number of rows
        int rows = arr1.length;

        // Finding the number of columns (assuming a rectangular 2D array)
        int cols = arr1[0].length;  // Since all rows have the same number of columns

        // Printing the size and shape of the array
        System.out.println("Number of rows: " + rows);
        System.out.println("Number of columns: " + cols);
        System.out.println("Shape of the array: " + rows + "x" + cols);
        
        // Calculating the total number of elements
        int totalElements = rows * cols;

        // Printing the total number of elements
        System.out.println("Total number of elements in the array: " + totalElements);
    }
}
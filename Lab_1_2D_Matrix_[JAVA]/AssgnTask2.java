//Assignment Task 02: Matrix Compression
class AssgnTask2{

    public static Integer[][] compressMatrix( Integer[][] matrix ){

        int m=matrix.length/2;
        int n=matrix[0].length/2;

        Integer[][] nm=new Integer[m][n];

        for(int r=0; r<matrix.length; r+=2){
            for(int c=0; c<matrix[0].length; c+=2){
                nm[r/2][c/2]=matrix[r][c]+matrix[r][c+1]+matrix[r+1][c]+matrix[r+1][c+1];
            }
        }

        return nm;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}



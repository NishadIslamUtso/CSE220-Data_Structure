
public class t1 {
    public static void main(String[] args){
        int[][] arr = {
            {0, 1, 0,  0, 0, 0, 0}, 
            {5, 0, 0,  0, 0, 0, 0}, 
            {12, 7, 0,  0, 0, 0, 0}, 
            {19, 14, 7,  0, 0, 0, 0}, 
            {14, 9, 2,  1, 0, 0, 0}, 
            {11, 11, 4, 3, 2, 0, 0}, 
            { 3, 4, 3,  2, 1, 1, 0}};
        System.out.println("Adjacency Matrix Representation:");
        print2DArray(arr);
        System.out.println("Max Degree:"+ maxDegree(arr));
        System.out.println("Max Weight:"+ maxWeight(arr));
        directedToUndirected(arr);
         System.out.println("Undirected Adjacency Matrix Representation:");
        print2DArray(arr);

    }
    public static void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(); 
        }
    }
    public static int maxDegree(int[][] obj){

        int temp=0;
        int max=0;

        for(int i=0; i<obj.length; i++){
            temp=0;
            for(int j=0; j<obj[0].length;j++){
                if(obj[i][j]>0){
                    temp++;
                }
            }
            if(temp>max) max=temp;
        }
        return max;
    }

     public static int maxWeight(int[][] obj){

        int temp=0;
        int max=0;

        for(int i=0; i<obj.length; i++){
            temp=0;
            for(int j=0; j<obj[0].length;j++){
                if(obj[i][j]>0){
                    temp+=obj[i][j];
                }
            }
            if(temp>max) max=temp;
        }
        return max;
    }
    public static void directedToUndirected(int[][] obj){

        for(int i=0; i<obj.length; i++){
            for(int j=i+1; j<obj[0].length;j++){
                if(obj[i][j]>0 || obj[j][i]>0){
                    int temp=obj[i][j]+obj[j][i];
                    obj[j][i]=obj[i][j]=temp;
                }
            }
        }
    }
}

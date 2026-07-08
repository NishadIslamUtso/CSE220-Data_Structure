//Assignment Task 01: Row Rotation Policy
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer rowRotation( Integer examWeek, String[][] matrix ){
        
         int shift=(examWeek-1)%matrix.length;
        

         for(int s=0; s<shift; s++){

             String[] temp=new String[matrix[0].length];

             for(int c=0; c<matrix[0].length; c++){
                 temp[c]=matrix[matrix.length-1][c];
             }

             for(int r=matrix.length-1; r>=1; r--){

                 for(int c=0; c<matrix[0].length; c++){
                     matrix[r][c]=matrix[r-1][c];
                 }
             }

             for(int c=0; c<matrix[0].length; c++){
                 matrix[0][c]=temp[c];
             }
         }
         
         for (int r=0; r<matrix.length; r++){

             for (int c=0; c<matrix[0].length; c++){
                 System.out.print("| "+matrix[r][c]+" | ");
             }

                System.out.println();
            }

            for (int r=0; r<matrix.length; r++){

                for (int c=0; c<matrix[0].length; c++){
                    
                    if(matrix[r][c].equals("AA")){
                        return r+1;
                    }
                }
            }
        return null;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        String[][] seatStatus = {
                {"A" , "B"  , "C"  , "D"  , "E"},
                {"F" , "G"  , "H"  , "I"  , "J"},
                {"K" , "L"  , "M"  , "N"  , "O"},
                {"P" , "Q"  , "R"  , "S"  , "T"},
                {"U" , "V"  , "W"  , "X"  , "Y"},
                {"Z" , "AA" , "BB" , "CC" , "DD"}
        };
        System.out.println("Given Seat Status: ");
        Arr.print2D(seatStatus);
        
        System.out.println("\nExpected Output:");
        System.out.println("| U  | V  | W  | X  | Y  | ");
        System.out.println("| Z  | AA | BB | CC | DD | ");
        System.out.println("| A  | B  | C  | D  | E  | ");
        System.out.println("| F  | G  | H  | I  | J  | ");
        System.out.println("| K  | L  | M  | N  | O  | ");
        System.out.println("| P  | Q  | R  | S  | T  | ");
        System.out.println("Your friend AA will be on row 2");
        
        System.out.print("\nYour Output:\n");
        Integer examWeek = 3;
        //This following should print modified seat status after rotation and return the current exam week
        Integer rowNumber = rowRotation( examWeek, seatStatus );
        //The following should print Your friend AA will be on row 2
        System.out.println("Your friend AA will be on row "+rowNumber);
    }
}

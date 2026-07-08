//Assignment Task 04: Rotate Secret
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    //If needed you can create extra helper static methods
    //if extra helper methods are used then you must submit those as well
    public static void rotateSecret( Character[][] board ){

        int n=board.length;

        for(int l=(n/2)-1; l>=0; l--){

            int start=l;
            int last=n-1-l;
            int spin=n/2-l;

            for(int s=0; s<spin; s++){

                Character temp = board[start][start];

                for (int i = start; i < last; i++){
                   board[i][start] = board[i + 1][start];
                }

                for (int i = start; i < last; i++){
                    board[last][i] = board[last][i + 1];
                }

                for (int i = last; i > start; i--){
                    board[i][last] = board[i - 1][last];
                }

                 for (int i = last; i > start + 1; i--){
                    board[start][i] = board[start][i - 1];
                 }

                board[start][start + 1] = temp;
            }     
        }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                  System.out.print(board[i][j]);
                }
            }
        System.out.println();
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        System.out.print("===========Test#1===========\n");
        Character[][] board = {
          {'T','A','U','S'},
          {'A','R','I','.'},
          {'D','T','T','N'},
          {'S','C','F','U'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        Character[][] outputBoard = {
            {'D','A','T','A'},
            {'S','T','R','U'},
            {'C','T','I','S'},
            {'F','U','N','.'}
        };
        System.out.print("DATASTRUCTISFUN.\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 1 Success");
        else System.out.println("Test 1 FAILED");
        
        System.out.print("\n===========Test#2===========\n");

        board = new Character[][]{
          {'O','R','I','R','N','P'},
          {'G','S','A','A','L','R'},
          {'L','M','N','O','N','Y'},
          {'A','H','U','O','O','P'},
          {'T','F','C','T','H','S'},
          {'E','D','Y','O','C','K'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        outputBoard = new Character[][]{
            {'A','L','G','O','R','I'},
            {'T','H','M','S','A','R'},
            {'E','F','U','N','A','N'},
            {'D','C','O','O','L','P'},
            {'Y','T','H','O','N','R'},
            {'O','C','K','S','P','Y'}
        };
        System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKSPY\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 2 Success");
        else System.out.println("Test 2 FAILED");
    }
}

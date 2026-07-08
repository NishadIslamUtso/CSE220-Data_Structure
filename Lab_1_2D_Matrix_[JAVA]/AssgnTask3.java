//Assignment Task 03: Game Arena
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void playGame( Integer[][] arena ){
        int points=0;
        for(int r=0; r<arena.length; r++){
            for(int c=0; c<arena[0].length; c++){

                if(arena[r][c]>2){

                    if(r>0){
                        if(arena[r-1][c]==2){
                            points++;
                        }
                    }

                    if(r<arena.length-1){
                        if(arena[r+1][c]==2){
                           points++;
                      }
                   }

                    if(c>0){
                        if(arena[r][c-1]==2){
                         points++;
                        }
                    }
                

                    if(c<arena[0].length-1){
                        if(arena[r][c+1]==2){
                            points++;
                        }
                    }
                }
            }
        }
        points=points*2;

        System.out.print("Points Gained: " + points + ". ");
        if(points>=10){
            System.out.println("Your team has survived the game.");
        }
        else{
            System.out.println("Your team is out.");
        }
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
            {0,2,2,0},
            {50,1,2,0},
            {2,2,2,0},
            {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}

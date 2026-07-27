//YOU NEED TO RUN THIS CLASS TO TEST OUT THE METHODS
package AssignmentTask2;

public class HotPotato{

    public static String hotPotato(String[] players, int k) {

        LinkedListQueue q=new LinkedListQueue();

        for(int i=0;i<players.length;i++){
            q.enqueue(players[i]);
        }

        int count=0;
        Object p="";

        while(true){

            p=q.dequeue();

            if(q.isEmpty()) break;

            if(count%k==0 && count!=0){
                System.out.println(p+" eliminated");
                count=0;
                continue;
            }
            q.enqueue(p);
            count++;
        }

        return (String)p;
    }

    public static void main(String[] args) {

        System.out.println(".......Test Case #1.......");
        String[] players1 = {"Ali", "Ben", "Cia", "Dan", "Eli", "Faye"};
        int k1 = 3;
        String winner1 = hotPotato(players1, k1);
        System.out.println("Winner: " + winner1);

        System.out.println(".......Test Case #2.......");
        String[] players2 = {"Ali", "Rafi", "Sara", "Nina"};
        int k2 = 2;
        String winner2 = hotPotato(players2, k2);
        System.out.println("Winner: " + winner2);
    }
}

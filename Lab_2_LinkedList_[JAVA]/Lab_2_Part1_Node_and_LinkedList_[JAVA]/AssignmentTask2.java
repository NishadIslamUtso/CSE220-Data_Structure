// AssignmentTask2: Organize Books
import java.util.Arrays;
public class AssignmentTask2{
    
    // MUST SUBMIT this method
    public static Node organizeBooks(Node head, Integer[] popularity) {
        
        for(int i = 0; i < popularity.length - 1; i++){

            for(int j = i + 1; j < popularity.length; j++){

                if(popularity[i] < popularity[j]){
                    Integer temp = popularity[i];
                    popularity[i] = popularity[j];
                    popularity[j] = temp;

                    Object tempBook = getNodeAt(head, i).elem;
                    getNodeAt(head, i).elem = getNodeAt(head, j).elem;
                    getNodeAt(head, j).elem = tempBook;
                }
            }  
        }
        return head;
    }

    public static Node getNodeAt(Node head, int idx){
        if(head==null){
            return null;
        }
        
        Node current = head;
        
        for(int i=0; i<idx; i++){
            current=current.next;
        }
        return current;
    }
    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=================Test Case 1=================");
        Node books = LinkedList.createList(new String[]{"Dune", "IT", "Coraline", "Inferno", "Twilight"});
        Integer[] arr = { 8, 10, 5, 10, 6 };

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books);
        System.out.println(Arrays.toString(arr));
        
        System.out.println("\nExpected Output");
        System.out.println("IT -> Inferno -> Dune -> Twilight -> Coraline");
        
        System.out.println("Your Output");
        books = organizeBooks( books, arr );
        LinkedList.printLL(books);

       
        System.out.println("=================Test Case 2=================");
        Node books2 = LinkedList.createList(new String[]{"Hamlet", "Persuasion", "It", "Dracula", "Beloved"});
        Integer[] arr2 = {7, 9, 9, 6, 7};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("\nExpected Output");
        System.out.println("Persuasion -> It -> Hamlet -> Beloved -> Dracula");

        System.out.println("Your Output");
        books2 = organizeBooks(books2, arr2);
        LinkedList.printLL(books2);


        System.out.println("=================Test Case 3=================");
        Node books3 = LinkedList.createList(new String[]{"Matilda", "Franny", "Foundation", "Carrie", "Misery"});
        Integer[] arr3 = {5, 8, 8, 10, 6};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("\nExpected Output");
        System.out.println("Carrie -> Franny -> Foundation -> Misery -> Matilda");

        System.out.println("Your Output");
        books3 = organizeBooks(books3, arr3);
        LinkedList.printLL(books3);

    }
}

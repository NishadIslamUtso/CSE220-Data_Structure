public class Summer2025_HashTable {

    // Hash table size
    static final int SIZE = 5;

    // Array of linked lists for separate chaining
    static NodeInt[] ht = new NodeInt[SIZE];

    // Simple hash function: key % SIZE
    static int hash(int key) {
        return key % SIZE;
    }

    // Insert a key into the hash table (integer-only)
    static void insert(int key) {
        int index = hash(key);         // Step 1: Compute index
        NodeInt head = ht[index];      // Step 2: Get current chain
        NodeInt newNode = new NodeInt(key); // Step 3: Create new node

        if (head == null) {            // Step 4: Empty bucket
            ht[index] = newNode;
            return;
        }

        // Step 5: Insert at head if new key is smaller
        if (key < head.value) {
            newNode.next = head;
            ht[index] = newNode;
            return;
        }

        // Step 6: Traverse to find the correct position
        NodeInt prev = null;
        NodeInt succ = head;

        while (succ != null && succ.value < key) {
            prev = succ;
            succ = succ.next;
        }

        // Step 7: If key already exists, skip (or could ignore duplicates)
        if (succ != null && succ.value == key) {
            System.out.println("Duplicate key " + key + " ignored.");
        } else {
            // Step 8: Insert between prev and succ
            newNode.next = succ;
            prev.next = newNode;
        }
    }

    // Print the entire hash table
    static void printHashTable() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            NodeInt node = ht[i];
            while (node != null) {
                System.out.print(node.value + " -> ");
                node = node.next;
            }
            System.out.println("None");
        }
    }

    // Driver method
    public static void main(String[] args) {
        // Setup initial hash table (integer keys only)
        ht[0] = new NodeInt(3);
        ht[0].next = new NodeInt(4);

        ht[1] = new NodeInt(5);

        ht[2] = new NodeInt(2);
        ht[2].next = new NodeInt(9);

        ht[3] = new NodeInt(27);

        ht[4] = new NodeInt(10);
        ht[4].next = new NodeInt(11);

        // Print before insertion
        System.out.println("Before insertion:");
        printHashTable();

        // Insert key 8
        insert(8);

        // Print after insertion
        System.out.println("\nAfter inserting 8:");
        printHashTable();
    }
}

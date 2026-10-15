class HashTableExampleType2 {
    private int size;
    private Node[] table;

    public HashTableExampleType2(int size) {
        this.size = size;
        this.table = new Node[size]; // Initialize hash table
    }

    private int hashFunction(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i);
        }
        return hashValue % size;
    }

    public void insert(String key, int value) {
        int index = hashFunction(key);

        if (table[index] == null) {
            table[index] = new Node(null, -1); // Dummy head node, key is null, value is -1
        }

        // Prepend after dummy head
        Node newNode = new Node(key, value);
        Node predecessor = table[index]; // Predecessor is dummy head
        Node successor = predecessor.next;

        newNode.next = successor; // Link the successor
        predecessor.next = newNode; // Link the predecessor
    }

    public boolean search(String key) {
        /** Search for a key in the hash table. */
        int index = hashFunction(key);

        if (table[index] == null) {//no chain to search
            return false;
        }

        Node current = table[index].next; // Starting after dummy head
    
        while (current != null) { // Going till tail
            if (current.key == key) {  // If key matches, return true
                return true;
            }
            current = current.next;  // Move to the next node
        }
    
        return false;  // If the key is not found
    }


    
    public void remove(String remKey) {
        int index = hashFunction(remKey);

        // Start at the dummy head
        if (table[index] == null) {
            System.out.println("Key '" + remKey + "' not found.");
            return;
        }

        Node predecessor = table[index]; // Predecessor (head node), i = 0
        Node remNode = predecessor.next; // Node to be removed (remNode), j = i+1

        
        while (remNode != null) {
            if (remNode.key.equals(remKey)) { // Found the node to remove
                Node successor = remNode.next; // The node after remNode
                predecessor.next = successor; // Bypass remNode
                System.out.println("Removed (" + remNode.key + ", " + remNode.value + ")");
                return;
            }
            predecessor = remNode; // Move predecessor forward, i++
            remNode = remNode.next; // Move remNode forward, j++
        }

        System.out.println("Key '" + remKey + "' not found.");
    }


    public void printHashTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": "); // Print the index
    
            Node current;
    
            // Check if there is a chain (with a dummy head) at this index
            if (table[i] != null) {
                // Start from the first actual data node (skip dummy head)
                current = table[i].next;
            } else {
                // If the slot is completely empty, set current to null
                // will never enter the while loop
                current = null;
            }
    
            // Traverse the linked list at this index and print all nodes
            while (current != null) {
                System.out.print("(" + current.key + ", " + current.value + ") → ");
                current = current.next; // Move to the next node
            }
    
            // Indicate the end of the chain
            System.out.println("None");
        }
    
        // Extra newline for better formatting
        System.out.println();
    }


    public static void main(String[] args) {
        HashTableExampleType2 hashTable = new HashTableExampleType2(5);

        System.out.println("Hash table before insert:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        hashTable.printHashTable();

        hashTable.insert("cat", 10);
        hashTable.insert("dog", 20);
        hashTable.insert("rat", 40);
        hashTable.insert("owl", 50);
        hashTable.insert("fox", 60);
        hashTable.insert("ant", 70);
        hashTable.insert("bee", 80);

        System.out.println("Hash table after insert:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        hashTable.printHashTable();

        System.out.println("Hash table before search:");
        hashTable.printHashTable();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println(hashTable.search("rat")); // Output: true
        System.out.println(hashTable.search("owl")); // Output: true
        System.out.println(hashTable.search("hen")); // Output: false

        System.out.println("Hash table after search:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        hashTable.printHashTable();

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Hash table before removals:");
        hashTable.printHashTable();

        hashTable.remove("cat");
        hashTable.remove("owl");
        hashTable.remove("dog");

        System.out.println("\nHash table after removals:");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        hashTable.printHashTable();
    }
}

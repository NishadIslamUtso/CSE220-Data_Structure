// HashTable class using separate chaining with singly linked lists
class HashTableType1 {
    private int size;
    private SinglyLinkedList[] table;

    public HashTableType1(int size) {
        this.size = size;
        table = new SinglyLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new SinglyLinkedList();
        }
    }

    private int hash(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i);
        }
        return hashValue % size;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        table[index].prepend(key, value);
    }

    public Integer search(String key) {
        int index = hash(key);
        Node node = table[index].find(key);
        if (node != null) {
            return node.value;
        } else {
            return null;
        }
    }

    public boolean delete(String key) {
        int index = hash(key);
        return table[index].delete(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            table[i].display();
        }
    }
    
    
    
    public static void main(String[] args) {
        // Step 1: Create a hash table with 5 buckets
        HashTableType1 ht = new HashTableType1(5);

        // Step 2: Insert key-value pairs into the hash table
        ht.insert("cat", 10);   // bucket 2 (collision "cat", "rat")
        ht.insert("dog", 20);   // bucket 4
        ht.insert("rat", 40);   // bucket 2 (collision "cat", "rat")
        ht.insert("owl", 50);   // bucket 3 (collision among 'fox', 'ant', 'owl')
        ht.insert("fox", 60);   // bucket 3 (collision among 'fox', 'ant', 'owl')
        ht.insert("ant", 70);   // bucket 3 (collision among 'fox', 'ant', 'owl')
        ht.insert("bee", 80);   // bucket 0

        // Step 3: Display the current state of the hash table
        System.out.println("Initial hash table state:");
        ht.display();

        // Step 4: Search for a specific key
        System.out.println("\nSearch for 'bat': " + ht.search("bat"));
        System.out.println("Search for 'bee': " + ht.search("bee"));

        // Step 5: Delete a specific key
        System.out.println("\nDelete 'cat': " + ht.delete("cat"));
        System.out.println("Delete 'ant': " + ht.delete("ant"));

        // Step 6: Display the state of the hash table after deletion
        System.out.println("\nHash table state after deletion:");
        ht.display();
    }
}
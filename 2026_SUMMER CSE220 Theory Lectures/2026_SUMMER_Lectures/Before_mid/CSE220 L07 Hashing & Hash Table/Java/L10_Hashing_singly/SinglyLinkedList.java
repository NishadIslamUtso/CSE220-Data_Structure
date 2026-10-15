// Singly linked list class
class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = new Node(null, 0); // Dummy head
    }

    public Node find(String key) {
        Node current = head.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void prepend(String key, int value) {
        Node node = find(key);
        if (node != null) { // Update value if key exists
            node.value = value;
        } else {
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            head.next = newNode;
        }
    }

    
    public boolean delete(String key) {
        Node predecessor = head;
        Node remNode = predecessor.next;  // Node to be removed
    
        while (remNode != null) {  // Traverse the list
            if (remNode.key == key) {
                Node successor = remNode.next;  // Next node in the list
                predecessor.next = successor;   // Bypass remNode
                return true;  // Deletion successful
            }
            predecessor = remNode;  // Move forward
            remNode = remNode.next; // Update remNode
        }
    
        return false;  // Key not found
   }

    public void display() {
        Node current = head.next;
        while (current != null) {
            System.out.print("(" + current.key + ", " + current.value + ") -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

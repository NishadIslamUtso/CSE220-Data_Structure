public class Q5Graph {
    // ================= Approach 1 =================
    // Using Net Balance Array
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)

    static void richestVertexApproach1(Edge[] transaction) {

        int n = transaction.length;

        int[] balance = new int[n];

        for (int u = 0; u < n; u++) {

            Edge edge = transaction[u];

            while (edge != null) {

                int v = edge.toVertex;
                int w = edge.weight;

                balance[u] = balance[u] - w;
                balance[v] = balance[v] + w;

                edge = edge.next;
            }
        }

        int richest = 0;
        int maxBalance = balance[0];

        for (int i = 1; i < n; i++) {

            if (balance[i] > maxBalance) {
                maxBalance = balance[i];
                richest = i;
            }

            else if (balance[i] == maxBalance && i < richest) {
                richest = i;
            }
        }

        System.out.println("Account with highest money vertex: " + richest);
        System.out.println("Highest net money: " + maxBalance);
    }


    // ================= Approach 2 =================
    // Using Separate Incoming and Outgoing Arrays
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)

    static void richestVertexApproach2(Edge[] transaction) {

        int n = transaction.length;

        int[] incoming = new int[n];
        int[] outgoing = new int[n];

        for (int u = 0; u < n; u++) {

            Edge edge = transaction[u];

            while (edge != null) {

                int v = edge.toVertex;
                int w = edge.weight;

                outgoing[u] = outgoing[u] + w;
                incoming[v] = incoming[v] + w;

                edge = edge.next;
            }
        }

        int richest = 0;
        int maxBalance = incoming[0] - outgoing[0];

        for (int i = 1; i < n; i++) {

            int net = incoming[i] - outgoing[i];

            if (net > maxBalance) {
                maxBalance = net;
                richest = i;
            }

            else if (net == maxBalance && i < richest) {
                richest = i;
            }
        }

        System.out.println("Account with highest money vertex: " + richest);
        System.out.println("Highest net money: " + maxBalance);
    }


    // ================= Approach 3 =================
    // Brute Force Method
    // Time Complexity: O(V * (V + E))
    // Space Complexity: O(1)

    static void richestVertexApproach3(Edge[] transaction) {

        int n = transaction.length;

        int richest = 0;
        int maxBalance = Integer.MIN_VALUE;

        for (int x = 0; x < n; x++) {

            int incoming = 0;
            int outgoing = 0;

            for (int u = 0; u < n; u++) {

                Edge edge = transaction[u];

                while (edge != null) {

                    int v = edge.toVertex;
                    int w = edge.weight;

                    if (u == x) {
                        outgoing = outgoing + w;
                    }

                    if (v == x) {
                        incoming = incoming + w;
                    }

                    edge = edge.next;
                }
            }

            int net = incoming - outgoing;

            if (net > maxBalance) {
                maxBalance = net;
                richest = x;
            }

            else if (net == maxBalance && x < richest) {
                richest = x;
            }
        }

        System.out.println("Account with highest money vertex: " + richest);
        System.out.println("Highest net money: " + maxBalance);
    }


    // ================= Print Graph =================

    static void printGraph(Edge[] graph) {

        for (int i = 0; i < graph.length; i++) {

            System.out.print(i + " : ");

            Edge temp = graph[i];

            while (temp != null) {

                System.out.print("(" + temp.toVertex + ", " + temp.weight + ")");

                if (temp.next != null) {
                    System.out.print(" -> ");
                }

                temp = temp.next;
            }

            System.out.println();
        }
    }


    
    // ================= Helper Method =================

    static void addEdge(Edge[] graph, int from, int to, int weight) {

        Edge newEdge = new Edge(to, weight);

        if (graph[from] == null) {
            graph[from] = newEdge;
        }

        else {

            Edge temp = graph[from];

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newEdge;
        }
    }
    // ================= Main Driver =================
    

    public static void main(String[] args) {

        Edge[] transaction = new Edge[7];

        addEdge(transaction, 0, 3, 100);
        addEdge(transaction, 0, 2, 300);
        addEdge(transaction, 0, 1, 400);

        addEdge(transaction, 1, 6, 200);

        addEdge(transaction, 2, 5, 500);

        addEdge(transaction, 3, 2, 200);

        addEdge(transaction, 4, 0, 100);
        addEdge(transaction, 4, 2, 800);

        addEdge(transaction, 5, 3, 500);

        addEdge(transaction, 6, 5, 300);

        System.out.println("Sample Given Graph & Adjacency List:");
        printGraph(transaction);

        System.out.println("\nApproach 1 Output:");
        richestVertexApproach1(transaction);

        System.out.println("\nApproach 2 Output:");
        richestVertexApproach2(transaction);

        System.out.println("\nApproach 3 Output:");
        richestVertexApproach3(transaction);
    }
}
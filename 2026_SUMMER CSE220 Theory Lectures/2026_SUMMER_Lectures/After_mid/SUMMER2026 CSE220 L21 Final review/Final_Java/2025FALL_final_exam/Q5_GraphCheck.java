class Q5_GraphCheck {

    // =========================
    // Style 1 (Efficient)
    // =========================
    // - Computes in-degree and out-degree in ONE traversal of adjacency list
    // - Time Complexity: O(V + E) → more efficient

    static int[][] networkCheck1(Edge[] network) {
        int n = network.length;  // number of vertices

        int[][] deg = new int[n][2];

        for (int i = 0; i < n; i++) {
            deg[i][0] = 0;
            deg[i][1] = 0;  // [in-degree, out-degree]
        }

        // Single traversal of adjacency list
        for (int u = 0; u < n; u++) {
            Edge cur = network[u];
            while (cur != null) {
                int v = cur.destination;
                deg[u][1] += 1;  // increment out-degree of u
                deg[v][0] += 1;  // increment in-degree of v
                cur = cur.next;
            }
        }

        int in0 = deg[0][0];   // reference in-degree
        int out0 = deg[0][1];  // reference out-degree

        boolean regular = true;
        // Check if all vertices have same in/out degree
        for (int i = 1; i < n; i++) {
            if (deg[i][0] != in0 || deg[i][1] != out0) {
                regular = false;
                break;
            }
        }

        // Output result
        if (regular) {
            System.out.println("Regular graph (Style 1)");
        } else {
            System.out.println("Not regular graph (Style 1)");
        }

        return deg;
    }


    // =========================
    // Method 2 (Less Efficient)
    // =========================
    // - Uses separate helper functions (in_degree, out_degree)
    // - in_degree scans the whole graph for each vertex
    // - Time Complexity: O(V * (V + E)) → less efficient

    // Counts outgoing edges of vertex v
    static int out_degree(Edge[] network, int v) {
        int count = 0;
        Edge e = network[v];
        while (e != null) {
            count += 1;
            e = e.next;
        }
        return count;
    }

    // Counts incoming edges of vertex v (scans entire graph)
    static int in_degree(Edge[] network, int v) {
        int count = 0;
        for (int i = 0; i < network.length; i++) {
            Edge e = network[i];
            while (e != null) {
                if (e.destination == v) {
                    count += 1;
                }
                e = e.next;
            }
        }
        return count;
    }


    // =========================
    // Style 2 (Less Efficient)
    // =========================
    // - Uses helper functions → repeated traversal → O(V * (V + E))

    static int[][] NetworkCheck2(Edge[] network) {
        int n = network.length;  // number of vertices

        int[][] arr2D = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr2D[i][0] = 0;
            arr2D[i][1] = 0;  // [in-degree, out-degree]
        }

        // Compute degrees using helper functions
        for (int i = 0; i < n; i++) {
            arr2D[i][0] = in_degree(network, i);   // in-degree
            arr2D[i][1] = out_degree(network, i);  // out-degree
        }

        int ref_in = arr2D[0][0];    // reference in-degree
        int ref_out = arr2D[0][1];   // reference out-degree

        boolean regular = true;
        // Check if all vertices match reference degrees
        for (int i = 1; i < n; i++) {
            if (arr2D[i][0] != ref_in || arr2D[i][1] != ref_out) {
                regular = false;
                break;
            }
        }

        // Output result
        if (regular) {
            System.out.println("Regular graph (Style 2)");
        } else {
            System.out.println("Not regular graph (Style 2)");
        }

        return arr2D;
    }

    //========================================================================================
    // =========================
    // PRINT FUNCTION--NOT PART OF ANS
    // =========================
    static void printReturned2DArray(int[][] deg) {
        System.out.print("Returned 2DArray:\n{");
        for (int i = 0; i < deg.length; i++) {
            System.out.print("{" + deg[i][0] + ", " + deg[i][1] + "}");
            if (i != deg.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
        System.out.println();
    }


    // =========================
    // SINGLE TESTER
    // =========================
    static void tester(int[][] edges, int n) {
        AdjacencyListGraph g = new AdjacencyListGraph(n);
        g.add_edges(edges);

        System.out.println("\nAdjacency List:");
        g.print_list();

        System.out.println("\n--- Using Style 1 ---");
        int[][] deg1 = networkCheck1(g.adj_list);
        printReturned2DArray(deg1);

        System.out.println("\n--- Using Style 2 ---");
        int[][] deg2 = NetworkCheck2(g.adj_list);
        printReturned2DArray(deg2);
    }


    // =========================
    // RUN TESTS
    // =========================
    public static void main(String[] args) {

        // Sample 1
        int[][] edges1 = {
            {0, 1}, {0, 2}, {0, 3},
            {1, 0}, {1, 2}, {1, 3},
            {2, 0}, {2, 1}, {2, 3},
            {3, 0}, {3, 1}, {3, 2}
        };
        tester(edges1, 4);

        // Sample 2
        int[][] edges2 = {
            {0, 1}, {0, 2},
            {1, 2}, {1, 3},
            {2, 3},
            {3, 4},
            {4, 1}
        };
        tester(edges2, 5);
    }
}
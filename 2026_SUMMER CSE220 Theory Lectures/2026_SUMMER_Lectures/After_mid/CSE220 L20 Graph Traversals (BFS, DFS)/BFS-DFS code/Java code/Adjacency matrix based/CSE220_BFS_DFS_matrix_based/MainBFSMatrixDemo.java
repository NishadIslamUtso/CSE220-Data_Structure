public class MainBFSMatrixDemo {
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1}, {0, 3},
            {1, 2}, {1, 4},
            {3, 1}, {3, 4},
            {4, 2}
        };

        GraphDirectedMatrix graph = new GraphDirectedMatrix(numVertices);
        graph.addEdges(edges);

        System.out.println("Adjacency Matrix:");
        graph.printMatrix();

        System.out.println("\n=== BFS Style 1 ===");
        Object[] result1 = GraphTraversalBFS_MatrixStyle1.bfs_style1(graph, 0);
        int[] distance1 = (int[]) result1[0];
        Integer[] parent1 = (Integer[]) result1[1];
        
        System.out.println("\nResults (Vertex, Distance, Parent):");
        for (int v = 0; v < numVertices; v++) {
            System.out.print("(" + v + ", " + distance1[v] + ", ");
            if (parent1[v] == null) {
                System.out.println("null)");
            } else {
                System.out.println(parent1[v] + ")");
            }
        }

        System.out.println("\nprintPath for BFS Style 1:");
        System.out.print("Path from 0 to 2: ");
        GraphTraversalBFS_MatrixStyle1.printPath(parent1, 0, 2);
        System.out.println();

        System.out.print("Path from 0 to 4: ");
        GraphTraversalBFS_MatrixStyle1.printPath(parent1, 0, 4);
        System.out.println();

        System.out.print("Path from 0 to 3: ");
        GraphTraversalBFS_MatrixStyle1.printPath(parent1, 0, 3);
        System.out.println();

        System.out.println("\n=== BFS Style 2 ===");
        Object[] result2 = GraphTraversalBFS_MatrixStyle2.bfs_style2(graph, 0);
        int[] distance2 = (int[]) result2[0];
        Integer[] parent2 = (Integer[]) result2[1];

        System.out.println("\nResults (Vertex, Distance, Parent):");
        for (int v = 0; v < numVertices; v++) {
            System.out.print("(" + v + ", " + distance2[v] + ", ");
            if (parent2[v] == null) {
                System.out.println("null)");
            } else {
                System.out.println(parent2[v] + ")");
            }
        }

        System.out.println("\nprintPath for BFS Style 2:");
        System.out.print("Path from 0 to 2: ");
        GraphTraversalBFS_MatrixStyle2.printPath(parent2, 0, 2);
        System.out.println();

        System.out.print("Path from 0 to 4: ");
        GraphTraversalBFS_MatrixStyle2.printPath(parent2, 0, 4);
        System.out.println();

        System.out.print("Path from 0 to 3: ");
        GraphTraversalBFS_MatrixStyle2.printPath(parent2, 0, 3);
        System.out.println();
    }
}

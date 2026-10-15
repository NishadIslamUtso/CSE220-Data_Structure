// =========================
// GIVEN CODE (DO NOT MODIFY)
// =========================

class AdjacencyListGraph {
    int num_vertices;
    Edge[] adj_list;

    AdjacencyListGraph(int num_vertices) {
        this.num_vertices = num_vertices;
        this.adj_list = new Edge[num_vertices];
    }

    void add_edges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            add_edge(edges[i][0], edges[i][1]);  // directed: source -> destination
        }
    }

    void add_edge(int source, int destination) {
        Edge new_edge = new Edge(source, destination);
        new_edge.next = this.adj_list[source];
        this.adj_list[source] = new_edge;
    }

    void print_list() {
        for (int i = 0; i < this.num_vertices; i++) {
            System.out.print(i + ": ");
            Edge cur = this.adj_list[i];
            boolean first = true;
            while (cur != null) {
                if (!first) {
                    System.out.print(" → ");
                }
                System.out.print("(" + cur.source + "," + cur.destination + ")");
                first = false;
                cur = cur.next;
            }
            System.out.println(",");
        }
    }
}
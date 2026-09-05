

// EdgeNode.java
class EdgeNode {
    int toV;
    int weight;
    EdgeNode next;

    public EdgeNode(int toV, int weight) {
        this.toV = toV;
        this.weight = weight;
        this.next = null;
    }
}

// GraphUtils.java
class GraphUtils {
    // Print a single adjacency list (linked list)
    public static void printLL(EdgeNode head) {
        EdgeNode n = head;
        while (n != null) {
            System.out.print(" -> (" + n.toV + "," + n.weight + ")");
            n = n.next;
        }
        System.out.println();
    }

    // Append a new edge node to adjacency list
    public static void appendLL(EdgeNode head, EdgeNode eNode) {
        EdgeNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = eNode;
    }

    // Add an edge to adjacency list (undirected graph)
    public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
        EdgeNode newNode = new EdgeNode(to, weight);
        if (adjList[from] == null) {
            adjList[from] = newNode;
        } else {
            GraphUtils.appendLL(adjList[from], newNode);
        }

        // // For undirected graph: also add reverse edge
        // EdgeNode reverseNode = new EdgeNode(from, weight);
        // if (adjList[to] == null) {
        //     adjList[to] = reverseNode;
        // } else {
        //     GraphUtils.appendLL(adjList[to], reverseNode);
        // }
    }

    // Show adjacency list for all vertices
    public static void showAdjList(EdgeNode[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ":");
            printLL(adjList[i]);
        }
    }
}

// GrpahDemo.java
public class GraphDemo {
    public static void main(String[] args) {
        int V = 7; // number of vertices
        EdgeNode[] adjList = new EdgeNode[V]; // array of adjacency lists

        // Add edges (directed)
        GraphUtils.addEdge(adjList, 0, 1, 1);
        GraphUtils.addEdge(adjList, 1, 0, 5);
        GraphUtils.addEdge(adjList, 2, 0, 12);
        GraphUtils.addEdge(adjList, 2, 1, 7);
        GraphUtils.addEdge(adjList, 3, 0, 19);
        GraphUtils.addEdge(adjList, 3, 1, 14);
        GraphUtils.addEdge(adjList, 3, 2, 7);
        GraphUtils.addEdge(adjList, 4, 0, 14);
        GraphUtils.addEdge(adjList, 4, 1, 9);
        GraphUtils.addEdge(adjList, 4, 2, 2);
        GraphUtils.addEdge(adjList, 4, 3, 1);
        GraphUtils.addEdge(adjList, 5, 0, 11);
        GraphUtils.addEdge(adjList, 5, 1, 11);
        GraphUtils.addEdge(adjList, 5, 2, 4);
        GraphUtils.addEdge(adjList, 5, 3, 3);
        GraphUtils.addEdge(adjList, 5, 4, 2);
        GraphUtils.addEdge(adjList, 6, 0, 3);
        GraphUtils.addEdge(adjList, 6, 1, 4);
        GraphUtils.addEdge(adjList, 6, 2, 3);
        GraphUtils.addEdge(adjList, 6, 3, 2);
        GraphUtils.addEdge(adjList, 6, 4, 1);
        GraphUtils.addEdge(adjList, 6, 5, 1);


        
        System.out.println("Adjacency List Representation:");
        GraphUtils.showAdjList(adjList);
        System.out.println("Max Degree:" +maxDegree(adjList));
        System.out.println("Max Weight:" +maxWeight(adjList));
        directedToUndirected(adjList);
        System.out.println("Undirected Adjacency List Representation:");
        GraphUtils.showAdjList(adjList);
    }

     public static int maxDegree(EdgeNode[] obj){
        EdgeNode t=null;
        int temp=0;
        int max=0;

        for(int i=0; i<obj.length;i++){
            t=obj[i];
            temp=0;
            while (t!=null){
                temp++;
                t=t.next;
            }
            if(temp>max) max=temp;
        }
        return max;
    }

     public static int maxWeight(EdgeNode[] obj){
        EdgeNode t=null;
        int temp=0;
        int max=0;

        for(int i=0; i<obj.length;i++){
            t=obj[i];
            temp=0;
            while (t!=null){
                temp+=t.weight;
                t=t.next;
            }
            if(temp>max) max=temp;
        }
        return max;
    }

      public static void directedToUndirected(EdgeNode[] obj){

        EdgeNode t=null;

        for(int i=0; i<obj.length;i++){
            t=obj[i];
            EdgeNode x=null;

            while (t!=null){
                x=obj[t.toV];
                boolean twoWays=false;
                while(x!=null){

                    if(x.toV==i){
                        twoWays=true;
                        break;
                    }
                    x=x.next;
                }
                if(twoWays){
                    if(i < t.toV){
                        int sum=t.weight+x.weight;
                        t.weight=sum;
                        x.weight=sum;
                    }
                }
                else GraphUtils.addEdge(obj,t.toV,i,t.weight);
                t=t.next;
            }
        }
    }
}

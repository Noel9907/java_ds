import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destination, int weight) {
            adjacencyList.get(source).add(new Edge(destination, weight));
            adjacencyList.get(destination).add(new Edge(source, weight)); // As it's an undirected graph
        }

        void primsMST() {
            boolean[] visited = new boolean[vertices];
            int[] parent = new int[vertices];
            int[] key = new int[vertices];
            Arrays.fill(key, Integer.MAX_VALUE);

            // Min-Heap to store (key, vertex) pairs
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            key[0] = 0;
            minHeap.add(new int[]{0, 0}); // (vertex, key)

            while (!minHeap.isEmpty()) {
                int[] current = minHeap.poll();
                int u = current[0]; // current vertex

                if (visited[u]) continue;

                visited[u] = true;

                // Traverse all adjacent vertices
                for (Edge edge : adjacencyList.get(u)) {
                    int v = edge.destination;
                    int weight = edge.weight;

                    // If the vertex is not yet included and the edge weight is smaller
                    if (!visited[v] && weight < key[v]) {
                        key[v] = weight;
                        parent[v] = u;
                        minHeap.add(new int[]{v, key[v]});
                    }
                }
            }

            // Print the constructed MST
            printMST(parent);
        }

        void printMST(int[] parent) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < vertices; i++) {
                System.out.println(parent[i] + " - " + i + " \t" + getEdgeWeight(parent[i], i));
            }
        }

        int getEdgeWeight(int u, int v) {
            for (Edge edge : adjacencyList.get(u)) {
                if (edge.destination == v) {
                    return edge.weight;
                }
            }
            return -1; // Not found
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (source destination weight): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        System.out.println("Minimum Spanning Tree (MST) using Prim's Algorithm:");
        graph.primsMST();

        scanner.close();
    }
}

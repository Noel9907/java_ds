import java.util.*;

class Kruskal {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    }

    static class DisjointSet {
        int[] parent, rank;
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int node) {
            if (parent[node] != node) parent[node] = find(parent[node]);
            return parent[node];
        }
        void union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
                else if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
                else { parent[rootV] = rootU; rank[rootU]++; }
            }
        }
    }

    static void kruskalMST(int vertices, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        DisjointSet ds = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                mst.add(edge);
                totalWeight += edge.weight;
                ds.union(edge.src, edge.dest);
            }
        }

        System.out.println("MST Edges:");
        for (Edge edge : mst) 
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        System.out.println("Total Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vertices: ");
        int v = sc.nextInt(), e = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        System.out.println("Edges (src dest weight):");
        for (int i = 0; i < e; i++) 
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        kruskalMST(v, edges);
        sc.close();
    }
}

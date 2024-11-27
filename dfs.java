import java.util.Scanner;

class dfs {
    private int vertices;
    private int[][] adjacencyMatrix;

    public dfs(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    public void dfs(int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public void performDFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfs(startVertex, visited);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        dfs graph = new dfs(vertices);

        int choice;
        do {
            System.out.println("\n1. Add Edge");
            System.out.println("2. Perform DFS");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter source and destination: ");
                    int source = scanner.nextInt();
                    int destination = scanner.nextInt();
                    graph.addEdge(source, destination);
                    break;
                case 2:
                    System.out.print("Enter the starting vertex: ");
                    int startVertex = scanner.nextInt();
                    System.out.println("DFS Traversal:");
                    graph.performDFS(startVertex);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
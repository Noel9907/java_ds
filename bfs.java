import java.util.Scanner;

class CustomQueue {
    private int[] elements;
    private int front, rear, size, capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        front = 0;
        size = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        elements[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = elements[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class bfs {
    private int vertices;
    private int[][] adjacencyMatrix;

    public bfs(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        CustomQueue queue = new CustomQueue(vertices);

        visited[startVertex] = true;
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        bfs graph = new bfs(vertices);
        System.out.println("\n1. Add Edge");
        System.out.println("2. Perform BFS");
        System.out.println("3. Exit");
        int choice;
        do {
           
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
                    System.out.println("BFS Traversal:");
                    graph.bfs(startVertex);
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
import java.util.Scanner;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor to initialize the queue
    public CircularQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    // Enqueue operation to add an element
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        if (isEmpty()) {
            front = 0; // First element added, set front to 0
        }
        rear = (rear + 1) % size; // Circular increment
        queue[rear] = element;
        System.out.println("Enqueued: " + element);
    }

    // Dequeue operation to remove an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int dequeuedElement = queue[front];
        if (front == rear) {
            // Queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size; // Circular increment
        }
        System.out.println("Dequeued: " + dequeuedElement);
        return dequeuedElement;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Peek operation to get the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return -1;
        }
        return queue[front];
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int capacity = scanner.nextInt();

        CircularQueue queue = new CircularQueue(capacity);

        int choice;
        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    int frontElement = queue.peek();
                    if (frontElement != -1) {
                        System.out.println("Front element: " + frontElement);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

import java.util.Scanner;

public class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public Queue(int size) {
        queue = new int[size];
        
        front = 0;
        rear = -1;
        capacity = size;
    }

    public void enqueue(int item) {
        if (rear + 1 == capacity) {
            System.out.println("Queue is full. Cannot enqueue " + item);
        } else {
            rear++;
            queue[rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int item = queue[front];
            front++;
            System.out.println("Dequeued: " + item);
            return item;
        }
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to enqueue: ");
                    int item = scanner.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
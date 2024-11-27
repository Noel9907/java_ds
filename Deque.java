import java.util.Scanner;

public class Deque {
    private int[] deque;
    private int front = -1, rear = -1, size;

    public Deque(int capacity) {
        deque = new int[capacity];
        size = capacity;
    }

    private boolean isEmpty() { return front == -1; }
    private boolean isFull() { return (front == 0 && rear == size - 1) || (rear + 1 == front); }

    public void insertFront(int element) {
        if (isFull()) { System.out.println("Deque full."); return; }
        front = (front == 0) ? size - 1 : front - 1;
        if (front == -1) front = rear = 0;
        deque[front] = element;
        System.out.println("Inserted " + element + " at front.");
    }

    public void insertRear(int element) {
        if (isFull()) { System.out.println("Deque full."); return; }
        rear = (rear == size - 1) ? 0 : rear + 1;
        if (isEmpty()) front = rear = 0;
        deque[rear] = element;
        System.out.println("Inserted " + element + " at rear.");
    }

    public int deleteFront() {
        if (isEmpty()) { System.out.println("Deque empty."); return -1; }
        int removed = deque[front];
        if (front == rear) front = rear = -1;
        else front = (front == size - 1) ? 0 : front + 1;
        System.out.println("Deleted " + removed + " from front.");
        return removed;
    }

    public int deleteRear() {
        if (isEmpty()) { System.out.println("Deque empty."); return -1; }
        int removed = deque[rear];
        if (front == rear) front = rear = -1;
        else rear = (rear == 0) ? size - 1 : rear - 1;
        System.out.println("Deleted " + removed + " from rear.");
        return removed;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Deque empty."); return; }
        int i = front;
        System.out.print("Deque: ");
        while (i != rear) { System.out.print(deque[i] + " "); i = (i + 1) % size; }
        System.out.println(deque[rear]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Capacity: ");
        Deque deque = new Deque(scanner.nextInt());
        int choice;
        do {
            System.out.println("\n1. Insert Front\n2. Insert Rear\n3. Delete Front\n4. Delete Rear\n5. Display\n6. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: deque.insertFront(scanner.nextInt()); break;
                case 2: deque.insertRear(scanner.nextInt()); break;
                case 3: deque.deleteFront(); break;
                case 4: deque.deleteRear(); break;
                case 5: deque.display(); break;
            }
        } while (choice != 6);
        scanner.close();
    }
}

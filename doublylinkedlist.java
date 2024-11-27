import java.util.Scanner;

public class DoublyLinkedList {
    class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) tail = newNode;
        else { newNode.next = head; head.prev = newNode; }
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) head = newNode;
        else { tail.next = newNode; newNode.prev = tail; }
        tail = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        if (pos <= 0 || head == null) { insertAtBeginning(data); return; }
        Node newNode = new Node(data), curr = head;
        for (int i = 0; i < pos - 1 && curr.next != null; i++) curr = curr.next;
        if (curr.next == null) { insertAtEnd(data); return; }
        newNode.next = curr.next;
        curr.next.prev = newNode;
        curr.next = newNode;
        newNode.prev = curr;
    }

    public void deleteAtBeginning() {
        if (head == null) return;
        if (head == tail) head = tail = null;
        else { head = head.next; head.prev = null; }
    }

    public void deleteAtEnd() {
        if (tail == null) return;
        if (head == tail) head = tail = null;
        else { tail = tail.prev; tail.next = null; }
    }

    public void deleteAtPosition(int pos) {
        if (pos < 0 || head == null) return;
        if (pos == 0) { deleteAtBeginning(); return; }
        Node curr = head;
        for (int i = 0; i < pos && curr != null; i++) curr = curr.next;
        if (curr == null) return;
        if (curr.next != null) curr.next.prev = curr.prev;
        if (curr.prev != null) curr.prev.next = curr.next;
    }

    public void display() {
        for (Node curr = head; curr != null; curr = curr.next) System.out.print(curr.data + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int ch, data, pos;
        System.out.println("""
            1. Insert at beginning
            2. Insert at end
            3. Insert at position
            4. Delete at beginning
            5. Delete at end
            6. Delete at position
            7. Display
            8. Exit
        """);
        do {
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> { System.out.print("Enter data: "); dll.insertAtBeginning(sc.nextInt()); }
                case 2 -> { System.out.print("Enter data: "); dll.insertAtEnd(sc.nextInt()); }
                case 3 -> { 
                    System.out.print("Enter data and position: "); 
                    dll.insertAtPosition(sc.nextInt(), sc.nextInt());
                }
                case 4 -> dll.deleteAtBeginning();
                case 5 -> dll.deleteAtEnd();
                case 6 -> { System.out.print("Enter position: "); dll.deleteAtPosition(sc.nextInt()); }
                case 7 -> dll.display();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (ch != 8);
        sc.close();
    }
}

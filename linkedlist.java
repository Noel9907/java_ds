import java.util.Scanner;

class LinkedList {

    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        if (head == null) { head = new Node(data); return; }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new Node(data);
    }

    public void insertAtPosition(int data, int position) {
        if (position == 1) { insertAtBeginning(data); return; }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) System.out.println("Position out of bounds");
        else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteAtBeginning() {
        if (head == null) System.out.println("List is empty.");
        else head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null) System.out.println("List is empty.");
        else if (head.next == null) head = null;
        else {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            temp.next = null;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) { System.out.println("List is empty."); return; }
        if (position == 1) { deleteAtBeginning(); return; }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) temp = temp.next;
        if (temp == null || temp.next == null) System.out.println("Position out of bounds");
        else temp.next = temp.next.next;
    }

    public void displayList() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, data, position;
        System.out.println("""
                \nMenu:
                1. Insert at the beginning
                2. Insert at the end
                3. Insert at a position
                4. Delete from the beginning
                5. Delete from the end
                6. Delete at a position
                7. Display the list
                8. Exit
                """);

        while (true) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> { System.out.print("Enter value: "); list.insertAtBeginning(scanner.nextInt()); }
                case 2 -> { System.out.print("Enter value: "); list.insertAtEnd(scanner.nextInt()); }
                case 3 -> {
                    System.out.print("Enter value: ");
                    data = scanner.nextInt();
                    System.out.print("Enter position: ");
                    list.insertAtPosition(data, scanner.nextInt());
                }
                case 4 -> list.deleteAtBeginning();
                case 5 -> list.deleteAtEnd();
                case 6 -> {
                    System.out.print("Enter position: ");
                    list.deleteAtPosition(scanner.nextInt());
                }
                case 7 -> list.displayList();
                case 8 -> { System.out.println("Exiting..."); scanner.close(); System.exit(0); }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

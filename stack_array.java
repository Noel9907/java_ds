import java.util.Scanner;

public class stack_array {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public stack_array(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed onto the stack.");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            System.out.println(stackArray[top] + " popped from the stack.");
            return stackArray[top--];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to display.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        stack_array stack = new stack_array(size);

        int choice;
        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display all elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.display();
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}

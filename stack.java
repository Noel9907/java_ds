import java.util.Scanner;

public class stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed " + value + " to the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stack stack = new stack(5);  

        while (true) {
            System.out.println("Choose an operation: 1) Push 2) Pop 3) Peek 4) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to push:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped element is: " + popped);
                    }
                    break;
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element is: " + topElement);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

import java.util.Scanner;
class string {
    private char[] stackArray;
    private static int top;
    public string(int size) {
        stackArray = new char[size];
        top = -1;
    }

    public void push(char x) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = x;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public char pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty!");
            return '\0';
        }
    }

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word:");
        String str = sc.nextLine();

        string stack = new string(str.length());

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        System.out.print("Reversed word: ");
        while (top != -1) {
            System.out.print(stack.pop());
        }
        System.out.println();

    }
}
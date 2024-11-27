import java.util.Scanner;

public class PostfixEvaluation {
    public int precedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    class Stack {
        char[] stack;
        int top;
        public Stack(int size) {
            stack = new char[size];
            top = -1;
        }
        public void push(char c) {
            top++;
            stack[top] = c;
        }
        public char pop() {
            if (top == -1) {
                return '\0';
            }
            char popped = stack[top];
            top--;
            return popped;
        }
        public char peek() {
            if (top == -1) {
                return '\0'; 
            }
            return stack[top];
        }
        public boolean stackIsEmpty() {
            return top == -1;
        }
    }

    class CustomString {
        char[] chars;
        int index;
        
        public CustomString(int size) {
            chars = new char[size];
            index = 0;
        }
        
        public void add(char c) {
            chars[index++] = c;
        }
        
        public String toString() {
            return new String(chars, 0, index);
        }
    }

    public String infixToPostfix(String s) {
        Stack stack = new Stack(s.length());
        CustomString result = new CustomString(s.length());

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.add(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (stack.peek() != '(') {
                    result.add(stack.pop());
                }
                stack.pop(); 
            }
            else if (isOperator(ch)) {
                while (!stack.stackIsEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    if (ch == '^' && stack.peek() == '^') {
                        break;
                    } else {
                        result.add(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }
        while (!stack.stackIsEmpty()) {
            result.add(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PostfixEvaluation converter = new PostfixEvaluation();
        System.out.println("Enter the infix expression:");
        String infix = sc.nextLine();
        String postfix = converter.infixToPostfix(infix);
        System.out.println("Postfix expression is: " + postfix);
    }
}
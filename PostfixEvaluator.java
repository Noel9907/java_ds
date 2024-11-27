import java.util.Scanner;

public class PostfixEvaluator {

    public static int evaluate(String expression) {
        String[] tokens = expression.split("\\s+");
        int[] stack = new int[tokens.length];
        int top = -1;

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack[++top] = Integer.parseInt(token);
            } else {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                int result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "^":
                        result = (int) Math.pow(operand1, operand2);
                        break;
                }
                stack[++top] = result;
            }
        }

        return stack[top];
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression (use space-separated numbers and operators): ");
        String expression = scanner.nextLine();
        int result = evaluate(expression);
        System.out.println("Result of the postfix expression: " + result);
    }
}

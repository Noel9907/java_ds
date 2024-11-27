import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String original = scanner.nextLine();
        scanner.close();

        char[] charArray = original.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        String reversed = new String(charArray);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
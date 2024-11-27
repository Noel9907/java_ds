import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        int currentSize = 0;  
        while (true) {
            System.out.println("\nArray Operations Menu:");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Display the array");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (currentSize < size) {
                        System.out.print("Enter the element to insert: ");
                        int element = scanner.nextInt();
                        array[currentSize] = element;
                        currentSize++;
                        System.out.println("Element inserted.");
                    } else {
                        System.out.println("Array is full! Cannot insert more elements.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the index of the element to delete: ");
                    int indexToDelete = scanner.nextInt();
                    if (indexToDelete >= 0 && indexToDelete < currentSize) {
                        for (int i = indexToDelete; i < currentSize - 1; i++) {
                            array[i] = array[i + 1];
                        }
                        currentSize--;
                        System.out.println("Element deleted.");
                    } else {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Array elements:");
                    for (int i = 0; i < currentSize; i++) {
                        System.out.print(array[i] + " ");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
// Start.
// Input the size of the array (size).
// Initialize an array of integers with the specified size.
// Set currentSize = 0 to keep track of the number of elements in the array.
// Repeat the following until the user chooses to exit:
// Display the menu of options:
// Insert an element
// Delete an element
// Display the array
// Exit
// Input the user's choice.
// If the choice is:
// 1 (Insert an element):
// If currentSize < size, then:
// Input the element to insert.
// Store the element in array[currentSize].
// Increment currentSize by 1.
// Print "Element inserted."
// Else print "Array is full!"
// 2 (Delete an element):
// Input the index of the element to delete.
// If the index is valid (between 0 and currentSize - 1), then:
// Shift all elements to the left from the index to delete the element.
// Decrement currentSize by 1.
// Print "Element deleted."
// Else print "Invalid index."
// 3 (Display the array):
// Print all elements from array[0] to array[currentSize - 1].
// 4 (Exit):
// Print "Exiting..." and terminate the program.
// If the choice is invalid, print "Invalid option. Please try again."
// End.
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows of Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter number of columns of Matrix A: ");
        int colsA = scanner.nextInt();

        System.out.print("Enter number of rows of Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter number of columns of Matrix B: ");
        int colsB = scanner.nextInt();

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible. Columns of A must match rows of B.");
            return;
        }

        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

// ALGORITHM 
// Start.
// Input the number of rows (rowsA) and columns (colsA) for Matrix A.
// Input the number of rows (rowsB) and columns (colsB) for Matrix B.
// Check if matrix multiplication is possible:
// If colsA != rowsB, print "Matrix multiplication not possible" and exit.
// Input the elements of Matrix A (matrixA).
// Input the elements of Matrix B (matrixB).
// Initialize the result matrix (result) with dimensions rowsA x colsB.
// Perform matrix multiplication:
// For each i from 0 to rowsA - 1:
// For each j from 0 to colsB - 1:
// Initialize result[i][j] to 0.
// For each k from 0 to colsA - 1:
// Multiply matrixA[i][k] * matrixB[k][j] and add the product to result[i][j].
// Output the result matrix.
// End.
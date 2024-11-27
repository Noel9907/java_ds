import java.util.Scanner;

public class PolynomialAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the degree of the first polynomial: ");
        int degree1 = scanner.nextInt();
        int[] coefficients1 = new int[degree1 + 1];
        System.out.println("Enter the coefficients for the first polynomial (from highest to lowest degree):");
        for (int i = 0; i <= degree1; i++) {
            coefficients1[i] = scanner.nextInt();
        }

        System.out.print("Enter the degree of the second polynomial: ");
        int degree2 = scanner.nextInt();
        int[] coefficients2 = new int[degree2 + 1];
        System.out.println("Enter the coefficients for the second polynomial (from highest to lowest degree):");
        for (int i = 0; i <= degree2; i++) {
            coefficients2[i] = scanner.nextInt();
        }

        int maxDegree = (degree1 > degree2) ? degree1 : degree2;
        int[] resultCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int coef1 = (i <= degree1) ? coefficients1[i] : 0;
            int coef2 = (i <= degree2) ? coefficients2[i] : 0;
            resultCoefficients[i] = coef1 + coef2;
        }

        System.out.print("Resultant Polynomial: ");
        for (int i = maxDegree; i >= 0; i--) {
            if (resultCoefficients[i] != 0) {
                System.out.print(resultCoefficients[i] + "x^" + i);
                if (i > 0) {
                    System.out.print(" + ");
                }
            }
        }
        System.out.println();

        scanner.close();
    }
}

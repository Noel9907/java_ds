import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();
        scanner.close();

        System.out.println("Prime numbers up to " + limit + ":");
        for (int num = 2; num <= limit; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// ALGORITHM
// Start.
// Input the value n (the limit up to which primes are to be found).
// Loop from num = 2 to num <= n:
// Initialize a flag isPrime = true.
// Check divisibility:
// Loop from i = 2 to i <= sqrt(num):
// If num % i == 0, set isPrime = false and break the loop (because num is not prime).
// If isPrime == true, print num (it is a prime number).
// Repeat the process for all numbers from 2 to n.
// End.
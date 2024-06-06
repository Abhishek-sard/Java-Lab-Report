import java.util.Scanner;

public class FactorialCalculator {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        } else {
            return n * factorial(n - 1); // Recursive call to find factorial
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();
        scanner.close();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            int result = factorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
        }
    }
}

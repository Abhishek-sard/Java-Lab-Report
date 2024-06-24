import java.util.Scanner;

public class StringIO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Display the original string
        System.out.println("Original String: " + userInput);
        
        // Convert to Upper Case
        String upperCase = userInput.toUpperCase();
        System.out.println("Upper Case: " + upperCase);
        
        // Convert to Lower Case
        String lowerCase = userInput.toLowerCase();
        System.out.println("Lower Case: " + lowerCase);
        
        // Find the length of the string
        int length = userInput.length();
        System.out.println("Length of String: " + length);
        
        // Reverse the string
        String reversed = new StringBuilder(userInput).reverse().toString();
        System.out.println("Reversed String: " + reversed);
        
        // Check if the string contains a substring
        System.out.print("Enter a substring to search for: ");
        String substring = scanner.nextLine();
        boolean contains = userInput.contains(substring);
        System.out.println("Contains '" + substring + "': " + contains);
        
        // Replace a part of the string
        System.out.print("Enter the part of the string to replace: ");
        String toReplace = scanner.nextLine();
        System.out.print("Enter the replacement: ");
        String replacement = scanner.nextLine();
        String replaced = userInput.replace(toReplace, replacement);
        System.out.println("Replaced String: " + replaced);
        
        // Split the string by spaces
        String[] words = userInput.split(" ");
        System.out.println("Split String: ");
        for (String word : words) {
            System.out.println(word);
        }
        
        // Close the scanner
        scanner.close();
    }
}



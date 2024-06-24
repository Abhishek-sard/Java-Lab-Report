public class StringManipulation {

    public static void main(String[] args) {
        // Initial String
        String original = "Hello, World!";
        System.out.println("Original String: " + original);
        
        // Concatenation
        String concatenated = original + " How are you?";
        System.out.println("Concatenated String: " + concatenated);
        
        // Substring Extraction
        String substring = original.substring(7, 12);
        System.out.println("Substring (7, 12): " + substring);
        
        // String Replacement
        String replaced = original.replace("World", "Java");
        System.out.println("Replaced String: " + replaced);
        
        // Case Conversion
        String upperCase = original.toUpperCase();
        String lowerCase = original.toLowerCase();
        System.out.println("Upper Case: " + upperCase);
        System.out.println("Lower Case: " + lowerCase);
        
        // Splitting a String
        String[] splitArray = original.split(", ");
        System.out.println("Split Array: ");
        for (String part : splitArray) {
            System.out.println(part);
        }
        
        // Trimming Whitespace
        String stringWithSpaces = "   Trim me!   ";
        String trimmed = stringWithSpaces.trim();
        System.out.println("Trimmed String: '" + trimmed + "'");
        
        // Checking if String contains a substring
        boolean contains = original.contains("World");
        System.out.println("Contains 'World': " + contains);
        
        // Getting the length of the String
        int length = original.length();
        System.out.println("Length of String: " + length);
        
        // String comparison
        String anotherString = "hello, world!";
        boolean equalsIgnoreCase = original.equalsIgnoreCase(anotherString);
        System.out.println("Equals Ignore Case: " + equalsIgnoreCase);
    }
}


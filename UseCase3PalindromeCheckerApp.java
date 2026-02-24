
public class UseCase3PalindromeCheckerApp {

    /**
     * Application entry point for UC3.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        // Hardcoded input string
        String input = "level";

        String reversed = "";

        // Iterate string in reverse order
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Display original and reversed strings
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);

        // Compare original and reversed strings
        if (input.equals(reversed)) {
            System.out.println("Result: The string is a PALINDROME.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}
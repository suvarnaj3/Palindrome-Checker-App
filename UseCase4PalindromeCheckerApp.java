

public class UseCase4PalindromeCheckerApp {

    /**
     * Application entry point for UC4.
     *
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "radar";

        // Convert the string into a character array
        char[] chars = input.toCharArray();

        // Initialize pointer at the beginning
        int start = 0;

        // Initialize pointer at the end
        int end = chars.length - 1;

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Continue comparison until pointers cross
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display the result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
import java.util.Scanner;

/**
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * 
 * Use Case 10: Normalized Palindrome Validation
 * 
 * Description:
 * This class validates a palindrome after preprocessing the input string.
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 * 
 * @author Developer
 * @version 10.0
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");
        System.out.print("Enter string: ");
        String input = scanner.nextLine();


        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome && !normalized.isEmpty()) {
            System.out.println("Result: \"" + input + "\" is a valid normalized palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}
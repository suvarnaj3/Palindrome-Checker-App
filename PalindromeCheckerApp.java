import java.util.Scanner;

/**
 * MAIN CLASS - UseCase9RecursivePalindrome
 * 
 * Use Case 9: Recursive Palindrome Checker
 * 
 * Description:
 * This class validates a palindrome using recursion.
 * Characters are compared from the outer positions
 * moving inward using recursive calls.
 * 
 * The recursion stops when:
 * - All characters are matched, or
 * - A mismatch is found.
 * 
 * @author Developer
 * @version 9.0
 */
public class PalindromeCheckerApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC9: Recursive Palindrome Checker ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = check(cleanInput, 0, cleanInput.length() - 1);

        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }


    private static boolean check(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return check(s, start + 1, end - 1);
    }
}
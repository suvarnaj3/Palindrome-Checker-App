import java.util.Scanner;


class PalindromeChecker {
    

    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        PalindromeChecker service = new PalindromeChecker();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter text to validate: ");
        String userInput = scanner.nextLine();

        boolean result = service.checkPalindrome(userInput);

        if (result) {
            System.out.println("SUCCESS: The input is a valid palindrome.");
        } else {
            System.out.println("FAILURE: The input is not a palindrome.");
        }

        scanner.close();
    }
}
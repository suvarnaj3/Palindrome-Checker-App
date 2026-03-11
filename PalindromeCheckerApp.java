import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * Description: Demonstrates how different palindrome validation algorithms 
 * can be selected dynamically at runtime using the Strategy Design Pattern.
 * 
 * @author Garv
 * @version 12.0
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String testInput = "madam";

        PalindromeContext checker = new PalindromeContext();

        System.out.println("Testing with Input: " + testInput);

        checker.setStrategy(new StackStrategy());
        System.out.println("Using Stack Strategy: " + checker.check(testInput));

        checker.setStrategy(new DequeStrategy());
        System.out.println("Using Deque Strategy: " + checker.check(testInput));
    }
}


interface PalindromeStrategy {
    boolean isPalindrome(String input);
}


class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return clean.equals(reversed.toString());
    }
}


class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }
        
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}


class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(text);
    }
}
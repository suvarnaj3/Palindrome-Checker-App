import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * 
 * Use Case 13: Performance Comparison
 * 
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 * 
 * @author Garv
 * @version 13.0
 */
public class PalindromeCheckerApp {


    public static void main(String[] args) {
        String testInput = "racecar".repeat(1000);
        
        PalindromeContext checker = new PalindromeContext();

        System.out.println("Palindrome Algorithm Performance Benchmarking");
        System.out.println("Input Size: " + testInput.length() + " characters\n");

        checker.setStrategy(new StackStrategy());
        benchmark(checker, "Stack-Based Strategy", testInput);

        checker.setStrategy(new DequeStrategy());
        benchmark(checker, "Deque-Based Strategy", testInput);
    }


    private static void benchmark(PalindromeContext context, String name, String input) {
        long startTime = System.nanoTime();
        boolean result = context.check(input);
        long endTime = System.nanoTime();
        
        long duration = endTime - startTime;

        System.out.println("Algorithm: " + name);
        System.out.println("Is Palindrome: " + result);
        System.out.println("Execution Time: " + duration + " nanoseconds");
    }
}


interface PalindromeStrategy {
    boolean isPalindrome(String input);
}


class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return input.equals(reversed.toString());
    }
}


class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
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
        if (strategy == null) return false;
        return strategy.isPalindrome(text);
    }
}
import java.util.*;

// -------- Strategy Interface --------
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// -------- Stack Strategy --------
class StackStrategy implements PalindromeStrategy {

    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public boolean isPalindrome(String input) {
        String str = normalize(input);

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// -------- Deque Strategy --------
class DequeStrategy implements PalindromeStrategy {

    private String normalize(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public boolean isPalindrome(String input) {
        String str = normalize(input);

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// -------- Context Class (Uses Strategy) --------
class PalindromeChecker {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Change strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// -------- Main Application --------
class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Choose strategy dynamically
        System.out.println("\nChoose Strategy:");
        System.out.println("1. Stack आधारित");
        System.out.println("2. Deque आधारित");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        // Inject strategy
        PalindromeChecker checker = new PalindromeChecker(strategy);

        // Execute
        if (checker.check(input)) {
            System.out.println("It is a Palindrome ✅");
        } else {
            System.out.println("It is NOT a Palindrome ❌");
        }

        sc.close();
    }
}

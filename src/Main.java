import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase4PalindromeCheckerApp {

    /**
     * Application entry point for UC4.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        // Convert string into character array
        char[] chars = input.toCharArray();

        // Initialize pointers
        int start = 0;
        int end = chars.length - 1;

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        // -------- UC7 Deque Based Palindrome Check --------

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.addLast(Character.toLowerCase(c));
        }

        boolean dequePalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                dequePalindrome = false;
                break;
            }
        }

        System.out.println("Is Palindrome (Using Deque)? : " + dequePalindrome);

        sc.close();
    }
}
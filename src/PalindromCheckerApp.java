import java.util.Scanner;

public class PalindromeCheckerApp {

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

        sc.close();
    }
}
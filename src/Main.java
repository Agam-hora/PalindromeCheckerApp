
import java.util.Scanner;

class PalindromeCheckerApp {

    // Recursive function
    static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // UC10: Normalize string (remove spaces & ignore case)
    static String normalizeString(String str) {
        // Remove all non-alphanumeric characters (including spaces)
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str.toLowerCase();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // -------- UC10 Normalization --------
        String normalized = normalizeString(input);

        // Reverse normalized string
        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed = reversed + normalized.charAt(i);
        }

        // Check using loop
        if (normalized.equals(reversed)) {
            System.out.println("It is a Palindrome (Ignoring spaces & case)");
        } else {
            System.out.println("It is NOT a Palindrome (Ignoring spaces & case)");
        }

        // -------- Recursive Check --------
        boolean result = isPalindromeRecursive(normalized, 0, normalized.length() - 1);

        if (result) {
            System.out.println("Palindrome (Recursion, UC10)");
        } else {
            System.out.println("Not a Palindrome (Recursion, UC10)");
        }

        sc.close();
    }
}
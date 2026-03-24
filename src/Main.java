import java.util.Scanner;

// -------- UC11: Palindrome Service Class --------
class PalindromeChecker {

    // Normalize string (remove spaces & ignore case)
    private String normalizeString(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str.toLowerCase();
    }

    // Iterative check using StringBuilder
    public boolean checkPalindrome(String input) {
        String normalized = normalizeString(input);

        StringBuilder reversed = new StringBuilder(normalized);
        reversed.reverse();

        return normalized.equals(reversed.toString());
    }

    // Recursive check
    public boolean checkPalindromeRecursive(String input) {
        String normalized = normalizeString(input);
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    // Internal recursive function
    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// -------- Main Application Class --------
class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Iterative check
        if (checker.checkPalindrome(input)) {
            System.out.println("It is a Palindrome (Service - Iterative)");
        } else {
            System.out.println("It is NOT a Palindrome (Service - Iterative)");
        }

        // Recursive check
        if (checker.checkPalindromeRecursive(input)) {
            System.out.println("Palindrome (Service - Recursion)");
        } else {
            System.out.println("Not a Palindrome (Service - Recursion)");
        }

        sc.close();
    }
}
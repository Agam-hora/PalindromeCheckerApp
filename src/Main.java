import java.util.Scanner;

class PalindromeCheckerApp {

    // Recursive function
    static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end)))
            return false;

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is NOT a Palindrome");
        }

        // -------- UC9 Recursive Palindrome Check --------

        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Palindrome (Checked using Recursion)");
        } else {
            System.out.println("Not a Palindrome (Checked using Recursion)");
        }

        sc.close();
    }
}
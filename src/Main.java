import java.util.Scanner;
import java.util.Stack;

class PalindromeCheckerApp {

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

        // -------- UC4 Character Array Based Palindrome Check --------

        char[] arr = input.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Palindrome (Checked using Character Array)");
        } else {
            System.out.println("Not a Palindrome (Checked using Character Array)");
        }

        // -------- UC5 Stack Based Palindrome Check --------

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String stackReverse = "";

        while (!stack.isEmpty()) {
            stackReverse = stackReverse + stack.pop();
        }

        if (input.equalsIgnoreCase(stackReverse)) {
            System.out.println("Palindrome (Checked using Stack)");
        } else {
            System.out.println("Not a Palindrome (Checked using Stack)");
        }

        sc.close();// test commit
    }
}
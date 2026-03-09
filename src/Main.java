import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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

        // -------- UC6 Queue + Stack Based Palindrome Check --------

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);      // LIFO
            queue.add(ch);       // FIFO
        }

        boolean isPalindrome = true;

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome (Checked using Queue and Stack)");
        } else {
            System.out.println("Not a Palindrome (Checked using Queue and Stack)");
        }

        sc.close();
    }
}
package datastructure.stack;

public class Main {

    // Reverse String
    public static String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Stack2<Character> stack = new Stack2<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return reversed;
    }

    // Parentheses Balanced
    public static boolean isBalancedParentheses(String s) {
        Stack2<Character> stack = new Stack2<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else if (c == '(') {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // Sort stack
    public static void sortStack(Stack2<Integer> stack) {
        Stack2<Integer> result = new Stack2<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!result.isEmpty() && temp < result.peek()) {
                stack.push(result.pop());
            }

            result.push(temp);
        }

        while (!result.isEmpty()) {
            stack.push(result.pop());
        }
    }

    public static void main(String[] args) {
        Stack2<Integer> stack = new Stack2<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();
    }
}

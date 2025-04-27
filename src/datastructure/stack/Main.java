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

    public static void main(String[] args) {
        String myString = "(()(())(()))";
        System.out.println(isBalancedParentheses(myString));

    }
}

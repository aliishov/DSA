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

    public static void main(String[] args) {
        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

    }
}

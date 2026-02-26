package problem20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpeningBracket(s.charAt(i)))
                stack.push(s.charAt(i));
            else {
                if (stack.empty())
                    return false;
                Character openBracket = stack.pop();
                if (!isCorrectBracket(openBracket, s.charAt(i)))
                    return false;
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;

    }

    public boolean isOpeningBracket(Character c) {
        if (c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }

    public boolean isCorrectBracket(Character o, Character c) {
        if (o == '{' && c == '}')
            return true;
        if (o == '[' && c == ']')
            return true;
        if (o == '(' && c == ')')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "){";
        System.out.println(new Solution().isValid(s));

    }
}
package list;

import java.util.*;
import java.util.LinkedList;

public class JavaMultipleParenthesesValidator {
    private final char[] openArr;
    private final char[] closeArr;

    /**
     * Parentheses for @param openArr and @param closeArr should be in the same order. f.e '{', '[' and '}', ']'
     */
    public JavaMultipleParenthesesValidator(char[] openArr, char[] closeArr) {
        this.openArr = openArr;
        this.closeArr = closeArr;
    }

    public boolean validate(String str) {
        if (str == null || str.isEmpty()) return false;

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Integer> openChars = mapFor(openArr);
        Map<Character, Integer> closeChars = mapFor(closeArr);

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (openChars.keySet().contains(curChar)) {
                stack.push(curChar);
            } else if (closeChars.keySet().contains(curChar)) {
                if (stack.isEmpty()) return false;

                Character topChar = stack.pop();
                // index for close char should correspond to open char in array of parentheses
                if (closeChars.get(curChar) != openChars.get(topChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Map<Character, Integer> mapFor(char[] chars) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            result.put(chars[i], i);
        }
        return result;
    }

}

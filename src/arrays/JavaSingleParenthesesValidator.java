package arrays;

public class JavaSingleParenthesesValidator {
    private final char open;
    private final char close;

    public JavaSingleParenthesesValidator(char open, char close) {
        this.open = open;
        this.close = close;
    }

    public boolean validate(String str) {
        int counter = 0;
        if (str == null || str.isEmpty()) return false;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (curChar == open) {
                counter++;
            } else if (curChar == close) {
                if (counter == 0) return false;

                counter--;
            }
        }
        return counter == 0;
    }

}

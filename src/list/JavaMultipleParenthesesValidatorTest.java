package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaMultipleParenthesesValidatorTest {
    static char[] openChars = {'[', '{', '('};
    static char[] closeChars = {']', '}', ')'};

    @Test
    public void valid_same_parentheses() {
        // given
        JavaMultipleParenthesesValidator validator = new JavaMultipleParenthesesValidator(openChars, closeChars);

        // when
        boolean actual = validator.validate("to ((be)) or (not) to be");

        // then
        assertTrue(actual);
    }

    @Test
    public void valid_different_parentheses() {
        // given
        JavaMultipleParenthesesValidator validator = new JavaMultipleParenthesesValidator(openChars, closeChars);

        // when
        boolean actual = validator.validate("to ([be]) or {not} to be");

        // then
        assertTrue(actual);
    }

    @Test
    public void not_valid_different_parentheses() {
        // given
        JavaMultipleParenthesesValidator validator = new JavaMultipleParenthesesValidator(openChars, closeChars);

        // when
        boolean actual = validator.validate("to ( [be] {or} not }");

        // then
        assertFalse(actual);
    }

    @Test
    public void startsClosedShouldFail() {
        // given
        JavaMultipleParenthesesValidator validator = new JavaMultipleParenthesesValidator(openChars, closeChars);

        // when
        boolean actual = validator.validate(")(");

        // then
        assertFalse(actual);
    }

    @Test
    public void notValidClosedPositionInTheMiddle() {
        // given
        JavaMultipleParenthesesValidator validator = new JavaMultipleParenthesesValidator(openChars, closeChars);

        // when
        boolean actual = validator.validate("to (be) }{ or not");

        // then
        assertFalse(actual);
    }

}
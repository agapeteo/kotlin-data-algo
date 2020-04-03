package arrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaSingleParenthesesValidatorTest {

    @Test
    public void validateCorrect() {
        // given
        JavaSingleParenthesesValidator validator = new JavaSingleParenthesesValidator('(', ')');

        // when
        boolean actual = validator.validate("to ((be)) or (not) to be");

        // then
        assertTrue(actual);
    }

    @Test
    public void validateIncorrect() {
        // given
        JavaSingleParenthesesValidator validator = new JavaSingleParenthesesValidator('(', ')');

        // when
        boolean actual = validator.validate("to ((be)(or) not");

        // then
        assertFalse(actual);
    }

    @Test
    public void startsClosedShouldFail() {
        // given
        JavaSingleParenthesesValidator validator = new JavaSingleParenthesesValidator('(', ')');

        // when
        boolean actual = validator.validate(")(");

        // then
        assertFalse(actual);
    }

    @Test
    public void notValidClosedPositionInTheMiddle() {
        // given
        JavaSingleParenthesesValidator validator = new JavaSingleParenthesesValidator('(', ')');

        // when
        boolean actual = validator.validate("to (be)) or (");

        // then
        assertFalse(actual);
    }

}
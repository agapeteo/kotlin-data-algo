package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SingleParenthesesValidatorTest {

    @Test
    fun validateCorrect() {
        // given
        val validator = SingleParenthesesValidator('(', ')')

        // when
        val actual = validator.validate("to ((be)) or (not) to be")

        // then
        assertTrue(actual)
    }

    @Test
    fun validateIncorrect() {
        // given
        val validator = SingleParenthesesValidator('(', ')')

        // when
        val actual = validator.validate("to ((be)(or) not")

        // then
        assertFalse(actual)
    }

    @Test
    fun startsClosedShouldFail() {
        // given
        val validator = SingleParenthesesValidator('(', ')')

        // when
        val actual = validator.validate(")(")

        // then
        assertFalse(actual)
    }

    @Test
    fun notValidClosedPositionInTheMiddle() {
        // given
        val validator = SingleParenthesesValidator('(', ')')

        // when
        val actual = validator.validate("to (be)) or (")

        // then
        assertFalse(actual)
    }
}

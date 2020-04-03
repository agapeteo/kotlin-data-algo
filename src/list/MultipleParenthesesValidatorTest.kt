package list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MultipleParenthesesValidatorTest {
    private val openChars = arrayOf('[', '{', '(')
    private val closeChars = arrayOf(']', '}', ')')

    @Test
    fun `valid with same parentheses`() {
        // given
        val validator = MultipleParenthesesValidator(openChars, closeChars)

        // when
        val actual = validator.validate("to ((be)) or (not) to be")

        // then
        assertTrue(actual)
    }

    @Test
    fun `valid different parentheses`() {
        // given
        val validator = MultipleParenthesesValidator(openChars, closeChars)

        // when
        val actual = validator.validate("to ([be]) or {not} to be")

        // then
        assertTrue(actual)
    }

    @Test
    fun `not valid different parentheses`() {
        // given
        val validator = MultipleParenthesesValidator(openChars, closeChars)

        // when
        val actual = validator.validate("to ( [be] {or} not }")

        // then
        assertFalse(actual)
    }

    @Test
    fun `starts closed should fail`() {
        // given
        val validator = MultipleParenthesesValidator(openChars, closeChars)

        // when
        val actual = validator.validate(")(")

        // then
        assertFalse(actual)
    }

    @Test
    fun `not valid closed position in the middle`() {
        // given
        val validator = MultipleParenthesesValidator(openChars, closeChars)

        // when
        val actual = validator.validate("to (be) }{ or not")

        // then
        assertFalse(actual)
    }
}
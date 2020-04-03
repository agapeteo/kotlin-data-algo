package math

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReverseIntDigitsTest {

    @Test
    fun `reverse 0`() {
        // given
        val number = 0

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(0, actual)
    }

    @Test
    fun `reverse 1`() {
        // given
        val number = 1

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(1, actual)
    }

    @Test
    fun `reverse 12`() {
        // given
        val number = 12

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(21, actual)
    }

    @Test
    fun `reverse 123`() {
        // given
        val number = 123

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(321, actual)
    }

    @Test
    fun `reverse 1234`() {
        // given
        val number = 1234

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(4321, actual)
    }

    @Test
    fun `reverse -1234`() {
        // given
        val number = -1234

        // when
        val actual = ReverseIntDigits.reverse(number)

        // then
        assertEquals(-4321, actual)
    }



}
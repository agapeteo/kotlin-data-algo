package sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuickSelectTest {

    @Test
    fun top_0() {
        // given
        val list = mutableListOf(2, 1, 4, 9, 7)

        // when
        val actual = QuickSelect.top(0, list)

        // then
        assertEquals(1, actual)
    }

    @Test
    fun top_1() {
        // given
        val list = mutableListOf(2, 1, 4, 9, 7)

        // when
        val actual = QuickSelect.top(1, list)

        // then
        assertEquals(2, actual)
    }

    @Test
    fun top_2() {
        // given
        val list = mutableListOf(2, 1, 4, 9, 7)

        // when
        val actual = QuickSelect.top(2, list)

        // then
        assertEquals(4, actual)
    }

    @Test
    fun top_3() {
        // given
        val list = mutableListOf(2, 1, 4, 9, 7)

        // when
        val actual = QuickSelect.top(3, list)

        // then
        assertEquals(7, actual)
    }

    @Test
    fun top_4() {
        // given
        val list = mutableListOf(2, 1, 4, 9, 7)

        // when
        val actual = QuickSelect.top(4, list)

        // then
        assertEquals(9, actual)
    }
}
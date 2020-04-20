package sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RadixSortTest {

    @Test
    fun sort() {
        val numbers = listOf(1, 12, 123, 3, 32, 321)

        val actual = RadixSort.sort(numbers)

        assertEquals(listOf(1, 3, 12, 32, 123, 321), actual)
    }


    @Test
    fun sort2() {
        val numbers = listOf(99999, 12, 1, 1, 3, 4, 3, 12)

        val actual = RadixSort.sort(numbers)

        assertEquals(listOf(1, 1, 3, 3, 4, 12, 12, 99999), actual)
    }
}
package sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListBasedCountingSortTest {
    @Test
    fun `1 2 3 4 5`() {
        // given
        val arr = intArrayOf(1, 2, 3, 4, 5)

        // when
        ListBasedCountingSort.sort(arr)

        assertEquals(intArrayOf(1, 2, 3, 4, 5).toList(), arr.toList())
    }

    @Test
    fun `5 4 3 2`() {
        // given
        val arr = intArrayOf(5, 4, 3, 2)

        // when
        ListBasedCountingSort.sort(arr)

        assertEquals(intArrayOf(2, 3, 4, 5).toList(), arr.toList())
    }

    @Test
    fun `1 2 3 4 2 3 7`() {
        // given
        val arr = intArrayOf(1, 2, 3, 4, 2, 3, 7)

        // when
        ListBasedCountingSort.sort(arr)

        assertEquals(intArrayOf(1, 2, 2, 3, 3, 4, 7).toList(), arr.toList())
    }

    @Test
    fun `0 2 0 0 6 0`() {
        // given
        val arr = intArrayOf(0, 2, 0, 0, 6, 0)

        // when
        ListBasedCountingSort.sort(arr)

        assertEquals(intArrayOf(0, 0, 0, 0, 2, 6).toList(), arr.toList())
    }

    @Test
    fun `randomized to 100`() {
        // given
        val intList = mutableListOf<Int>()

        repeat(100) {
            intList.add((0..100).random())
        }

        // when
        val arr = intList.toIntArray()
        ListBasedCountingSort.sort(arr)

        assertTrue(isSorted(arr))
    }

    private fun isSorted(arr: IntArray): Boolean {
        for (i in 1 until arr.size) {
            if (arr[i] < arr[i - 1]) return false
        }
        return true
    }
}
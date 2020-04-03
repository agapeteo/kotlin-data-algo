package sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MergeTwoSortedArraysKtTest {

    @Test
    fun `123 and 456`() {
        // given
        val bufPlaceHolder = -1
        val left = arrayOf(1, 2, 3, bufPlaceHolder, bufPlaceHolder, bufPlaceHolder)
        val right = arrayOf(4, 5, 6)

        // when
        sort.mergeArrays(left, 3, right)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5, 6), left.toList())
    }

    @Test
    fun `12344 and 456`() {//
        // given
        val bufPlaceHolder = -1
        val left = arrayOf(1, 2, 3, 4, 4, bufPlaceHolder, bufPlaceHolder, bufPlaceHolder)
        val right = arrayOf(4, 5, 6)

        // when
        sort.mergeArrays(left, 5, right)

        // then
        assertEquals(listOf(1, 2, 3, 4, 4, 4, 5, 6), left.toList())
    }

    @Test
    fun `45 and 123`() {
        // given
        val bufPlaceHolder = -1
        val left = arrayOf(4, 5, bufPlaceHolder, bufPlaceHolder, bufPlaceHolder)
        val right = arrayOf(1, 2, 3)

        // when
        sort.mergeArrays(left, 2, right)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), left.toList())
    }

    @Test
    fun `135 and 24`() {
        // given
        val bufPlaceHolder = -1
        val left = arrayOf(1, 3, 5, bufPlaceHolder, bufPlaceHolder)
        val right = arrayOf(2, 4)

        // when
        sort.mergeArrays(left, 3, right)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), left.toList())
    }

    @Test
    fun mod(){
       print(11%5)
    }
}
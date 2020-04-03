package sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QuickSortTest {

    @Test
    fun sort() {
        val list = mutableListOf(9, 1, 2, 0)
        val actual = QuickSort<Int>().sort(list)

        println(list)


    }
}
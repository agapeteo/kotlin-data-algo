package sort

import org.junit.jupiter.api.Test

internal class MergeSortTest {

    @Test
    fun sort() {
        val merge = MergeSort<Int>()
        val actual = merge.sort(mutableListOf(2, 1, 3, 9, 6, 7, 7))
//        val actual = merge.sort(mutableListOf(2, 1, 3, 9, 6, 7))

        println(actual)
        println(merge.visual.buildTextSequence())
    }
}
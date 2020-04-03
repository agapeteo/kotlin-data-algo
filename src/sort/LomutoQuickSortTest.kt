package sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LomutoQuickSortTest {

    @Test
    fun simpleAscending() {
        // given
        val array = arrayOf(1, 2, 3, 4, 5, 6)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(1, 2, 3, 4, 5, 6), array.toList())
    }

    @Test
    fun simpleDescending() {
        // given
        val array = arrayOf(5, 4, 3, 2, 1)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(1, 2, 3, 4, 5), array.toList())
    }

    @Test
    fun trickyCase() {
        // given
        val array = arrayOf(4, 2, 0, 5, 1)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(0, 1, 2, 4, 5), array.toList())
    }

    @Test
    fun simpleExample() {
        // given
        val array = arrayOf(1, 9, 3, 5, 4, 1)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(1, 1, 3, 4, 5, 9), array.toList())
    }

    @Test
    fun withMirroredDups() {
        // given
        val array = arrayOf(5, 5, 3, 5, 7, 5, 5)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(3, 5, 5, 5, 5, 5, 7), array.toList())
    }

    @Test
    fun withMirroredDups2() {
        // given
        val array = arrayOf(5, 5, 7, 8, 5, 3, 5, 1, 2, 3)

        // when
        LomutoQuickSort.sort(array)

        // then
        println(array.contentToString())
        assertEquals(listOf(1, 2, 3, 3, 5, 5, 5, 5, 7, 8), array.toList())
    }

}
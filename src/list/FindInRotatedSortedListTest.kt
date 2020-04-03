package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FindInRotatedSortedListTest {
    val verbose = false

    @Test
    fun findIdx() {
        // given
        val givenList = mutableListOf(0, 1, 2, 3, 4)
        val search = FindInRotatedSortedList(givenList)

        // when // then
        for (rotationCount in 0 until givenList.size) {
            rotateRight(if (rotationCount == 0) 0 else 1, givenList)

            if (verbose) println("\nlist after $rotationCount rotations: $givenList")

            assertEquals(-1, search.findIdx(9)) { "expected not existing 9 not found (-1)" }

            for (elementIdx in 0 until givenList.size) {

                val search = FindInRotatedSortedList(givenList)
                val actual = search.findIdx(givenList[elementIdx])

                assertEquals(actual, elementIdx) {
                    "expected ${elementIdx + rotationCount} but got $actual, for element ${givenList[elementIdx]} in list $givenList"
                }
                if (verbose) println("found ${givenList[elementIdx]} at index $actual")
            }
        }
    }

    private fun rotateRight(rotationCount: Int, list: MutableList<Int>) {
        repeat(rotationCount) {
            val last = list.last()

            for (i in list.size - 1 downTo 1) {
                list[i] = list[i - 1]
            }
            list[0] = last
        }
    }
}
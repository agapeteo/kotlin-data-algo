package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SortListNodeKtTest {

    @Test
    fun sort() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(5)
        list.append(3)
        list.append(1)
        list.append(5)
        list.append(7)
        list.append(4)
        list.append(0)

        // when
        list.sort()

        // then
        assertEquals(listOf(0, 1, 3, 4, 5, 5, 7), list.elements())
    }

    @Test
    fun `1 2 3 4 5`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)
        list.append(4)
        list.append(5)

        // when
        list.sort()

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), list.elements())
    }

    @Test
    fun `5 4 3 2 1`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(5)
        list.append(4)
        list.append(3)
        list.append(2)
        list.append(1)

        // when
        list.sort()

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), list.elements())
    }

    @Test
    fun `4, 2, 0, 5, 1`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(4)
        list.append(2)
        list.append(0)
        list.append(5)
        list.append(1)

        // when
        list.sort()

        // then
        assertEquals(listOf(0, 1, 2, 4, 5), list.elements())
    }

    @Test
    fun `1, 9, 3, 5, 4, 1`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(1)
        list.append(9)
        list.append(3)
        list.append(5)
        list.append(4)
        list.append(1)

        // when
        list.sort()

        // then
        assertEquals(listOf(1, 1, 3, 4, 5, 9), list.elements())
    }

    @Test
    fun `5, 5, 3, 5, 7, 5, 5`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(5)
        list.append(5)
        list.append(3)
        list.append(5)
        list.append(7)
        list.append(5)
        list.append(5)

        // when
        list.sort()

        // then
        assertEquals(listOf(3, 5, 5, 5, 5, 5, 7), list.elements())
    }

    @Test
    fun `5, 5, 7, 8, 5, 3, 5, 1, 2, 3`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.append(5)
        list.append(5)
        list.append(7)
        list.append(8)
        list.append(5)
        list.append(3)
        list.append(5)
        list.append(1)
        list.append(2)
        list.append(3)

        // when
        list.sort()

        // then
        assertEquals(listOf(1, 2, 3, 3, 5, 5, 5, 5, 7, 8), list.elements())
    }
}
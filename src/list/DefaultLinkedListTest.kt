package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DefaultLinkedListTest {

    @Test
    fun `empty list`() {
        // given
        // when
        val actual = DefaultLinkedList<Int>()

        // then
        assertEquals(0, actual.size())
        assertEquals(null, actual.getFirst())
        assertEquals(null, actual.getLast())
    }

    @Test
    fun append() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            append(1)
            append(2)
            append(3)
        }

        // then
        assertEquals(3, list.size())
        assertEquals(1, list.getFirst())
        assertEquals(3, list.getLast())
        assertEquals(2, list.elementByIndex(1))
    }

    @Test
    fun `get by index - empty`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when

        // then
        assertThrows(IllegalArgumentException::class.java) { list.get(0) }
    }

    @Test
    fun `get by index`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            append(1)
            append(2)
            append(3)
        }

        // then
        assertEquals(0, list.firstIndexOf(1))
        assertEquals(1, list.firstIndexOf(2))
        assertEquals(2, list.firstIndexOf(3))
        assertEquals(-1, list.firstIndexOf(4))
    }

    @Test
    fun `insert after index`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            addLast(1)
            addLast(3)
            insertAfterIndex(0, 2)
        }

        // then
        assertEquals(listOf(1, 2, 3), list.elements())
    }

    @Test
    fun `insert after index - multiple`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            addLast(1)
            addLast(4)
            insertAfterIndex(0, 2)
            insertAfterIndex(1, 3)
            insertAfterIndex(3, 5)
        }

        // then
        assertEquals(listOf(1, 2, 3, 4, 5), list.elements())
    }

    @Test
    fun `delete last`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.apply {
            addLast(0)
            addLast(1)
            addLast(2)
            addLast(3)
        }

        // when
        list.deleteLast()
        list.deleteLast()

        // then
        assertEquals(listOf(0, 1), list.elements())
    }

    @Test
    fun `delete last in empty`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.addLast(0)

        // when
        list.apply {
            deleteLast()
            deleteLast()
        }

        // then
        assertEquals(listOf<Int>(), list.elements())
    }

    @Test
    fun `delete last and add`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.addLast(0)

        // when
        list.apply {
            deleteLast()
            addLast(1)
        }

        // then
        assertEquals(listOf(1), list.elements())
    }

    @Test
    fun `delete first`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.apply {
            addLast(0)
            addLast(1)
        }

        // when
        list.deleteFirst()

        // then
        assertEquals(listOf(1), list.elements())
    }

    @Test
    fun `add first`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            addLast(3)
            addFirst(2)
            addFirst(1)
        }

        // then
        assertEquals(listOf(1, 2, 3), list.elements())
    }

    @Test
    fun `add first - empty`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.addFirst(1)

        // then
        assertEquals(listOf(1), list.elements())
    }

    @Test
    fun `reverse from head`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            append(3)
            append(2)
            append(1)

            reverseFromHead()
        }

        // then
        assertEquals(listOf(1, 2, 3), list.elements())
    }

    @Test
    fun `reverse from head - empty`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.reverseFromHead()

        // then
        assertEquals(listOf<Int>(), list.elements())
    }

    @Test
    fun `reverse from head - two`() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            append(2)
            append(1)

            reverseFromHead()
        }

        // then
        assertEquals(listOf(1, 2), list.elements())
    }

    @Test
    fun findKFromEnd() {
        // given
        val list: DefaultLinkedList<Int> = DefaultLinkedList()
        for (i in 1..10) {
            list.append(i)
        }

        // when
        val actual = list.findKFromEnd(2)

        // then
        assertEquals(8, actual)
    }

    @Test
    fun containsLoop_false() {
        // given
        val list: DefaultLinkedList<Int> = DefaultLinkedList()
        for (i in 1..10) {
            list.append(i)
        }

        // when // then
        val actual = list.containsLoop()

        // then
        assertFalse(actual)
    }

    @Test
    fun containsLoop_true() {
        // given
        val list: DefaultLinkedList<Int> = DefaultLinkedList()
        for (i in 1..10) {
            list.append(i)
        }

        // when // then
        list.createLoop()
        val actual = list.containsLoop()

        // then
        assertTrue(actual)
    }

}
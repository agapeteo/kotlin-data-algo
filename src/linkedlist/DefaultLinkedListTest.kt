package linkedlist

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DefaultLinkedListTest{

    @Test
    fun emptyList(){
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
    fun testList_getByIndex() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.apply {
            append(1)
            append(2)
            append(3)
        }

        // then
        assertEquals(1, list.get(0))
        assertEquals(2, list.get(1))
        assertEquals(3, list.get(2))
    }

    @Test
    fun testList_getByIndex_empty() {
        // given
        val list = DefaultLinkedList<Int>()

        // when

        // then
        assertThrows(IllegalArgumentException::class.java) { list.get(0) }
    }

    @Test
    fun getByIndex() {
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
    fun insertAfterIndex() {
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
    fun insertAfterIndex_multiple() {
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
    fun deleteLast() {
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
    fun deleteLast_inEmpty() {
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
    fun deleteLast_addAndDelete() {
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
    fun deleteFirst() {
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
    fun addFirst() {
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
    fun addFirst_empty() {
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.addFirst(1)

        // then
        assertEquals(listOf(1), list.elements())
    }

    @Test
    fun testReverseFromHead(){
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
    fun testReverseFromHead_empty(){
        // given
        val list = DefaultLinkedList<Int>()

        // when
        list.reverseFromHead()

        // then
        assertEquals(listOf<Int>(), list.elements())
    }

    @Test
    fun testReverseFromHead_two(){
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

}
package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ListSumsKtTest {

    @Test
    fun sumLists() {
        // given
        val firstList = DefaultLinkedList<Int>()
        firstList.addFirst(2)
        firstList.addFirst(3)
        firstList.addFirst(4)

        val secondList = DefaultLinkedList<Int>()
        secondList.addFirst(1)
        secondList.addFirst(1)

        // when
        val actual = list.sumLists(firstList, secondList)

        // then
        assertEquals(listOf(5, 4, 2), actual.elements())
    }

    @Test
    fun `list to int - 234`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.addFirst(2)
        list.addFirst(3)
        list.addFirst(4)

        // when
        val actual = list.listToInt()

        // then
        assertEquals(234, actual)
    }

    @Test
    fun `list to int - 11`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.addFirst(1)
        list.addFirst(1)

        // when
        val actual = list.listToInt()

        // then
        assertEquals(11, actual)
    }

    @Test
    fun `list to int - 5`() {
        // given
        val list = DefaultLinkedList<Int>()
        list.addFirst(5)

        // when
        val actual = list.listToInt()

        // then
        assertEquals(5, actual)
    }

    @Test
    fun `int to list - 234`() {
        // given
        // when
        val number = 234
        val actual = intToList(number)

        // then
        val expected = DefaultLinkedList<Int>()
        expected.addFirst(2)
        expected.addFirst(3)
        expected.addFirst(4)

        assertEquals(expected.elements(), actual.elements())
    }

    @Test
    fun `int to list - 11`() {
        // given
        // when
        val number = 11
        val actual = intToList(number)

        // then
        val expected = DefaultLinkedList<Int>()
        expected.addFirst(1)
        expected.addFirst(1)

        assertEquals(expected.elements(), actual.elements())
    }

    @Test
    fun `int to list - 5`() {
        // given
        // when
        val number = 5
        val actual = intToList(number)

        // then
        val expected = DefaultLinkedList<Int>()
        expected.addFirst(5)

        assertEquals(expected.elements(), actual.elements())
    }


}
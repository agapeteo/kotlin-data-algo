package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MinStackTest {

    @Test
    fun `increasing order`() {
        // given
        val stack = MinStack<Int>()

        // when
        stack.push(1)
        stack.push(2)
        stack.push(3)

        // then
        assertEquals(1, stack.min())
    }

    @Test
    fun `descreasing order`() {
        // given
        val stack = MinStack<Int>()

        // when
        stack.push(3)
        stack.push(2)
        stack.push(1)

        // then
        assertEquals(1, stack.min())
    }

    @Test
    fun `increasing and decreasing order`() {
        // given
        val stack = MinStack<Int>()

        // when
        stack.push(1)
        stack.push(2)
        stack.push(0)
        stack.push(-1)
        stack.push(3)

        // then
        assertEquals(-1, stack.min())
        stack.pop()
        stack.pop()
        assertEquals(0, stack.min())
        stack.pop()
        assertEquals(1, stack.min())
        assertEquals(2, stack.peek())
    }

    @Test
    fun `increasing and decreasing order with dups`() {
        // given
        val stack = MinStack<Int>()

        // when
        stack.push(1)
        stack.push(2)
        stack.push(0)
        stack.push(0)
        stack.push(-1)
        stack.push(3)

        // then
        assertEquals(-1, stack.min())
        stack.pop()
        stack.pop()
        assertEquals(0, stack.min())
        stack.pop()
        assertEquals(0, stack.min())
        stack.pop()
        assertEquals(1, stack.min())
        assertEquals(2, stack.peek())
    }
}
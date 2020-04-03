package arrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class EvictingRingBufferTest {
    @Test
    fun `overflow and dequeue`() {
        // given
        val buffer = EvictingRingBuffer<Int>(3)

        // when
        buffer.enqueue(1)
        buffer.enqueue(2)
        buffer.enqueue(3)
        buffer.enqueue(4)
        buffer.enqueue(5)
        buffer.enqueue(6)
        buffer.enqueue(7)
        val actual = buffer.dequeue()

        // then
        assertEquals(listOf(6, 7), buffer.elements().toList())
        assertEquals(5, actual)
    }
}
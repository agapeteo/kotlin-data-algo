package tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryHeapTest {

    @Test
    fun `max heap`() {
        // given
        val exampleList = listOf(10, 5, 3, 30, 25, 2, 0, -1, 200)

        val heap = BinaryHeap<Int>()

        // when
        exampleList.forEach{heap.push(it)}

        val actualList = mutableListOf<Int>()
        while(heap.size() > 0){
            actualList.add(heap.pop())
        }

        // then
        assertEquals(exampleList.sorted().reversed(), actualList)
    }
}
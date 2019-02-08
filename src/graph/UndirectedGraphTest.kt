package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UndirectedGraphTest {

    @Test
    fun elementsDfs() {
        // given
        val graph = Graph<Int>()
        buildSample(graph)

        // when
        val actual = graph.elementsDfs()

        // then
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertEquals(expected, actual.sorted())
    }

    @Test
    fun elementsBfs() {
        // given
        val graph = Graph<Int>()
        buildSample(graph)

        // when
        val actual = graph.elementsBfs()

        // then
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertEquals(expected, actual.sorted())
    }

    @Test
    fun connected() {
        // given
        val graph = Graph<Int>()
        buildSample(graph)

        // when
        graph.addEdge(0, -1)

        // then
        assertTrue(graph.connected(1, 8))
        assertTrue(graph.connected(1, 8))
        assertTrue(graph.connected(2, 1))
        assertFalse(graph.connected(1, -1))
    }

    private fun buildSample(graph: Graph<Int>) {
        graph.apply {
            addEdge(1, 2)

            addEdge(2, 1)
            addEdge(2, 5)
            addEdge(2, 3)
            addEdge(2, 4)

            addEdge(3, 2)
            addEdge(3, 4)

            addEdge(4, 2)
            addEdge(4, 3)
            addEdge(4, 6)

            addEdge(5, 2)

            addEdge(6, 4)
            addEdge(6, 7)
            addEdge(6, 8)

            addEdge(7, 6)
            addEdge(7, 8)

            addEdge(8, 7)
            addEdge(8, 6)
        }
    }
}
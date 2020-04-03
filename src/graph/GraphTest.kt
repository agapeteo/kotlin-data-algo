package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GraphTest {

    @Test
    fun elementsDfs() {
        // given
        val graph = Graph<String>()

        // when
        graph.addBothEdges("a", "b")
        graph.addBothEdges("b", "c")
        graph.addBothEdges("b", "d")
        graph.addBothEdges("c", "e")
        graph.addBothEdges("d", "e")
        val actual = graph.elementsDfs()

        // then
        assertEquals(listOf("a", "b", "c", "e", "d"), actual)
    }

    @Test
    fun elementsBfs() {
        // given
        val graph = Graph<String>()

        // when
        graph.addBothEdges("a", "b")
        graph.addBothEdges("b", "c")
        graph.addBothEdges("b", "d")
        graph.addBothEdges("c", "e")
        graph.addBothEdges("d", "e")
        val actual = graph.elementsBfs()

        // then
        assertEquals(listOf("a", "b", "c", "d", "e"), actual)
    }

    @Test
    fun shouldBeConnected() {
        // given
        val graph = Graph<String>()

        // when
        graph.addBothEdges("a", "b")
        graph.addBothEdges("b", "c")
        graph.addBothEdges("b", "d")
        graph.addBothEdges("c", "e")
        graph.addBothEdges("d", "e")

        // then
        assertTrue(graph.connected("a", "e"))
    }

    @Test
    fun shouldNotBeConnected() {
        // given
        val graph = Graph<String>()

        // when
        graph.addBothEdges("a", "b")
        graph.addBothEdges("b", "c")
        graph.addBothEdges("b", "d")
        graph.addBothEdges("c", "e")
        graph.addBothEdges("d", "e")

        graph.addBothEdges("x", "y")
        graph.addBothEdges("y", "z")

        // then
        assertFalse(graph.connected("a", "z"))
    }
}
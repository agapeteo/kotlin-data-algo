package graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.IllegalArgumentException

internal class GandzhaTopologySortTest {

    @Test
    fun `example 1`() {
        // given
        val projects = listOf("a", "b", "c", "b1", "b2", "c1", "c2")
        val dependencies = listOf(
                Pair("a", "b"),
                Pair("a", "c"),
                Pair("b", "b1"),
                Pair("b", "b2"),
                Pair("c", "c1"),
                Pair("c", "c2")
        )

        // when
        val actual = GandzhaTopologySort.topologySort(projects, dependencies)

        // then

        print(actual)
        assertEquals(7, actual.size)
        assertEquals("a", actual[actual.size - 1])
        assertTrue(
                actual[actual.size - 2] == "b" && actual[actual.size - 3] == "c"
                        || actual[actual.size - 3] == "b" && actual[actual.size - 2] == "c")
    }

    @Test
    fun `example 2`() {
        // given
        val projects = listOf("a", "b", "c", "d", "f")
        val dependencies = listOf(
                Pair("d", "a"),
                Pair("b", "f"),
                Pair("d", "b"),
                Pair("a", "f"),
                Pair("c", "d")
        )

        // when
        val actual = GandzhaTopologySort.topologySort(projects, dependencies)

        // then
        print(actual)
        assertEquals(5, actual.size)
        assertEquals("f", actual[0])
        assertEquals("d", actual[3])
        assertEquals("c", actual[4])
        assertTrue(
                actual[1] == "a" && actual[2] == "b"
                        || actual[2] == "a" && actual[1] == "b")
    }

    @Test
    fun `cycled should throw exception`() {
        // given
        val projects = listOf("a", "b", "c", "b1", "b2", "c1", "c2")
        val dependencies = listOf(
                Pair("a", "b"),
                Pair("a", "c"),
                Pair("b", "b1"),
                Pair("b", "b2"),
                Pair("c", "c1"),
                Pair("c", "c2"),
                Pair("c2", "b") // <- cycled here
        )

        // when
        var fails = false
        try {
            GandzhaTopologySort.topologySort(projects, dependencies)
        } catch (e: IllegalArgumentException) {
            fails = true
        }
        assertTrue(fails, "this test should throw exception for cycled dependency")
    }
}
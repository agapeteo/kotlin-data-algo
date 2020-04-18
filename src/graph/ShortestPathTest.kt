package graph

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class ShortestPathTest {

    @Test
    fun minPath() {
        val weightedGraph = WeightedGraph<String>()

        weightedGraph.addEdge("A", "B", 1.0)
        weightedGraph.addBothEdges("A", "C", 5.0)

        weightedGraph.addEdge("B", "C", 5.0)
        weightedGraph.addEdge("B", "E", 20.0)

        weightedGraph.addEdge("C", "D", 2.0)

        weightedGraph.addEdge("D", "B", 1.0)
        weightedGraph.addEdge("D", "E", 1.1)

        val actual = ShortestPath(graph = weightedGraph).minPath("A", "E")

        assertEquals(listOf("A", "C", "D", "E"), actual)
    }

    @Test
    fun `2 ways with same cost and undirected edges` () {
        val weightedGraph = WeightedGraph<String>()

        weightedGraph.addBothEdges("A", "B", 1.0)
        weightedGraph.addBothEdges("A", "C", 2.0)
        weightedGraph.addBothEdges("A", "D", 9.99)

        weightedGraph.addBothEdges("B", "D", 2.00)

        weightedGraph.addBothEdges("C", "D", 1.00)


        val actual = ShortestPath(graph = weightedGraph).minPath("A", "D")

        assertEquals(listOf("A", "B", "D"), actual)
    }
}
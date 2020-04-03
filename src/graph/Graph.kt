package graph

import java.util.*
import kotlin.collections.HashSet


class Graph<E> {

    val edges: MutableMap<E, HashSet<E>> = mutableMapOf()

    fun addEdge(from: E, to: E) {
        edges.computeIfAbsent(from) { HashSet() }.add(to)
    }

    fun addBothEdges(from: E, to: E) {
        addEdge(from, to)
        addEdge(to, from)
    }

    fun elementsDfs(): List<E> {
        val visited = mutableSetOf<E>()

        fun addToResult(element: E, list: MutableList<E>) {
            if (visited.contains(element)) return

            visited.add(element)
            list.add(element)
            edges[element]?.forEach { addToResult(it, list) }
        }

        val result = mutableListOf<E>()
        edges.keys.forEach { addToResult(it, result) }
        return result
    }

    fun elementsBfs(): List<E> {
        val result = mutableListOf<E>()
        val visited = mutableSetOf<E>()

        edges.keys.forEach { topElement ->
            val queue: Deque<E> = LinkedList()

            queue.add(topElement)
            while (queue.isNotEmpty()) {
                val element = queue.removeFirst()
                if (!visited.contains(element)) {
                    visited.add(element)
                    result.add(element)
                    edges[element]?.forEach { queue.add(it) }
                }
            }
        }
        return result
    }

    fun connected(from: E, to: E): Boolean { // using bfs
        if (from == to) return true

        val alreadyVisited = mutableSetOf<E>().apply { add(from) }
        val queue: Deque<E> = LinkedList()

        edges[from]?.forEach { queue.add(it) }

        while (queue.isNotEmpty()) {
            val element = queue.removeFirst()

            if (element == to) return true

            if (!alreadyVisited.contains(element)) {
                alreadyVisited.add(element)
                edges[element]?.forEach { queue.add(it) }
            }
        }
        return false
    }
}

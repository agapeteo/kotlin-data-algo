package graph


class Graph<E> {

    val graphData: HashMap<E, HashSet<E>> = HashMap()

    fun addEdge(from: E, to: E) {
        graphData.computeIfAbsent(from) { HashSet() }.add(to)
    }

    fun elementsDfs(): List<E> {
        val alreadyVisited = mutableSetOf<E>()

        fun add(element: E, list: MutableList<E>) {
            if (alreadyVisited.contains(element)) return

            alreadyVisited.add(element)
            list.add(element)
            graphData[element]?.forEach { add(it, list) }
        }

        val result: MutableList<E> = mutableListOf()
        graphData.keys.forEach { add(it, result) }
        return result
    }

    fun elementsBfs(): List<E> {
        val result: MutableList<E> = mutableListOf()
        val alreadyVisited = mutableSetOf<E>()

        graphData.keys.forEach { topElement ->
            val queue = mutableListOf<E>()

            queue.add(topElement)
            while (queue.isNotEmpty()) {
                val element = queue.removeAt(0)
                if (!alreadyVisited.contains(element)) {
                    alreadyVisited.add(element)
                    result.add(element)
                    graphData[element]?.forEach { queue.add(it) }
                }
            }
        }
        return result
    }


}

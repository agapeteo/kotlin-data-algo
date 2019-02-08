package graph

fun <E> Graph<E>.connected(from: E, to: E): Boolean {
    if (from == to) return true

    val alreadyVisited = mutableSetOf<E>().apply { add(from) }
    val queue = mutableListOf<E>()

    graphData[from]?.forEach { queue.add(it) }

    while (queue.isNotEmpty()) {
        val element = queue.removeAt(0)

        if (element == to) return true

        if (!alreadyVisited.contains(element)) {
            alreadyVisited.add(element)
            graphData[element]?.forEach { queue.add(it) }
        }
    }
    return false
}
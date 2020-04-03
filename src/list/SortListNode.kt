package list

import list.DefaultLinkedList.Node

fun <E : Comparable<in E>> DefaultLinkedList<E>.sort() {
    if (size < 2) return
    sortRange(head!!, tail!!)
}

fun <E : Comparable<in E>> sortRange(startNode: Node<E>, endNode: Node<E>) {
    if (startNode == endNode || endNode.next == startNode) return

    val partitionNode = partition(startNode, endNode)

    val partitionPrev = partitionNode.previous
    if (partitionPrev != null) {
        sortRange(startNode, partitionPrev)
    }

    val partitionNext = partitionNode.next
    if (partitionNext != null) {
        sortRange(partitionNext, endNode)
    }
}

fun <E : Comparable<in E>> partition(startNode: Node<E>, endNode: Node<E>): Node<E> {
    val pivotValue = endNode.value
    var slowNode = startNode
    var fastNode: Node<E>? = slowNode

    while (fastNode !== endNode) {
        if (fastNode!!.value <= pivotValue) {
            swapNodeValues(fastNode!!, slowNode)
            slowNode = slowNode.next!!
        }
        fastNode = fastNode.next
    }
    swapNodeValues(slowNode, endNode)
    return slowNode
}

fun <E> swapNodeValues(left: Node<E>, right: Node<E>) {
    val tmp = left.value
    left.value = right.value
    right.value = tmp
}


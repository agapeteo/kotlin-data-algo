package list

class RevListNode<T>(val value: T, var next: RevListNode<T>?)

fun <T> printValues(head: RevListNode<T>) {
    println()
    var curNode: RevListNode<T>? = head
    while (curNode != null) {
        print("${curNode.value}->")
        curNode = curNode.next
    }
    println()
}

fun <T> reverse(head: RevListNode<T>): RevListNode<T> {
    data class HeadAndTail(val head: RevListNode<T>, val tail: RevListNode<T>)

    fun reverseNode(node: RevListNode<T>): HeadAndTail {
        if (node.next == null) {
            return HeadAndTail(node, node)
        }
        val headAndTail = reverseNode(node.next!!)
        node.next = null
        headAndTail.tail.next = node

        return HeadAndTail(headAndTail.head, node)
    }
    return reverseNode(head).head
}

fun main() {
    val node1 = RevListNode("A", null)
    val node2 = RevListNode("B", null)
    val node3 = RevListNode("C", null)
    val node4 = RevListNode("D", null)

    node1.next = node2
    node2.next = node3
    node3.next = node4

    printValues(node1)

    val newHead = reverse(node1)
    printValues(newHead)
}



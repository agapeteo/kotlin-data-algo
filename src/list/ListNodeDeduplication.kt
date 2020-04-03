package list

fun <E> ListNode<E>.deduplicate() {
    val uniqueNodes = mutableSetOf<E>()
    var curNode: ListNode<E>? = this
    var uniqueNode: ListNode<E>? = null

    while (curNode != null) {
        if (uniqueNodes.contains(curNode.value)) {
            uniqueNode!!.next = curNode.next
        } else {
            uniqueNode = curNode
            uniqueNodes.add(curNode.value)
        }
        curNode = curNode.next
    }
}

package list

class ListNode<E>(inValue: E) {
    var value = inValue
    var next: ListNode<E>? = null
}

fun <E> ListNode<E>.append(intValue: E) {
    var curNode = this
    while (curNode.next != null) {
        curNode = curNode.next!!
    }
    curNode.next = ListNode(intValue)
}

fun <E> ListNode<E>.elements(): List<E> {
    val result = mutableListOf<E>()
    var curNode: ListNode<E>? = this

    while (curNode != null) {
        result.add(curNode.value)
        curNode = curNode.next
    }
    return result
}

fun <E> ListNode<E>.size(): Int {
    var size = 0
    var curNode: ListNode<E>? = this

    while (curNode != null) {
        size++
        curNode = curNode.next
    }
    return size
}


fun <E> ListNode<E>.removeAt(idx: Int) {
    val size = this.size()
    require(size > 1) { "expecting size is greater than 1" }
    require(idx in 1 until size) { "expecting idx should in range from 1 to list size exclusively" }

    if (size == 2) {
        this.next = null
        return
    }
    var prevNode = this
    var curNode = prevNode.next!!
    var nextNode: ListNode<E>? = curNode.next!!
    var curIdx = 1

    while (curIdx < idx && nextNode != null) {
        prevNode = prevNode.next!!
        curNode = curNode.next!!
        nextNode = nextNode.next
        curIdx++
    }
    prevNode.next = nextNode
}


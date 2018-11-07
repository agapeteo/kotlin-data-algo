package linkedlist


class DefaultLinkedList<E> : LinkedList<E> {

    private var size: Int = 0

    private var head: Node<E>? = null

    private var tail: Node<E>? = null

    data class Node<E>(val value: E, var previous: Node<E>? = null, var next: Node<E>? = null)

    override fun size(): Int {
        return size
    }

    override fun addLast(element: E) {
        append(element)
    }

    override fun append(element: E) {
        if (isEmpty()) {
            head = Node(element)
            tail = head
            size++
            return
        }

        val newNode = Node(element)
        newNode.previous = tail
        tail?.next = newNode
        tail = newNode

        tail = newNode
        size++
    }

    override fun elementByIndex(index: Int): E {
        return nodeByIndex(index).value
    }

    override fun get(index: Int): E {
        return elementByIndex(index)
    }

    private fun nodeByIndex(index: Int): Node<E> {
        require(index in 0..(size - 1)) { "$index is out of range of current list size $size" }

        var currentNode: Node<E>? = head ?: throw IllegalArgumentException("list is empty")

        var currentIndex = 0

        while (currentIndex < index) {
            currentIndex++
            currentNode = currentNode?.next
        }

        return currentNode ?: throw IllegalStateException("null node in the list but not expected")
    }

    private fun isEmpty(): Boolean {
        return head == null && tail == null
    }

    override fun deleteLast() {
        if (tail == null) return

        var currentTail = tail
        val newTail = tail?.previous
        newTail?.next = null
        tail = newTail
        currentTail = null
        size--
        if (size == 0) {
            head = null
            tail = null
        }
    }

    override fun addFirst(element: E) {
        if (isEmpty()) {
            append(element)
            return
        }

        val currentHead = head
        val newNode = Node(element)
        newNode.next = currentHead
        head = newNode
        size++
    }

    override fun deleteFirst() {
        if (head == null) return

        var oldHead = head
        val newHead = oldHead?.next
        head = newHead
        oldHead = null
        size--
    }

    override fun elements(): Collection<E> {
        val elements: MutableList<E> = mutableListOf()

        if (isEmpty()) return elements

        var currentNode: Node<E>? = head

        while (currentNode != null) {
            elements.add(currentNode.value)
            currentNode = currentNode.next
        }

        return elements
    }

    override fun firstIndexOf(element: E): Int {
        var currentIndex = 0
        var currentNode = head

        while (currentNode != null) {
            if (currentNode.value == element) return currentIndex
            currentIndex++
            currentNode = currentNode?.next
        }

        return -1
    }

    override fun insertAfterIndex(index: Int, element: E) {
        val nodeByIndex: Node<E> = nodeByIndex(index)

        val oldNext: Node<E>? = nodeByIndex.next
        val newNext = Node(element)

        newNext.previous = nodeByIndex
        newNext.next = oldNext
        oldNext?.previous = newNext

        nodeByIndex.next = newNext
        size++
    }

    override fun getFirst(): E? {
        return head?.value
    }

    override fun getLast(): E? {
        return tail?.value
    }

    fun reverseFromHead(){
        var prevNode: Node<E> = head ?: return

        var curNode: Node<E>? =
            if (prevNode.next != null)
                prevNode.next
            else {
                reverseTwoNodes()
                return
            }

        var nextNode: Node<E>? = curNode?.next

        swapHeadAndTail()

        while(curNode != null){

            if (prevNode.previous == null){
                prevNode.next = null
            }

            prevNode.previous = curNode

            curNode.next = prevNode
            curNode.previous = nextNode
            nextNode?.previous = curNode

            val nextNextNode: Node<E>? = nextNode?.next
            nextNode?.next = curNode

            prevNode = curNode
            curNode = nextNode
            nextNode = nextNextNode
        }
    }

    private fun swapHeadAndTail(){
        val tmpHead = head
        head = tail
        tail = tmpHead
    }

    private fun reverseTwoNodes() {
        head?.previous = tail
        head?.next = null

        tail?.next = head
        tail?.previous = null

        swapHeadAndTail()
    }

}
package list


class DefaultLinkedList<E : Comparable<E>> : LinkedList<E>, Stack<E>, Queue<E> {

    var size: Int = 0

    var head: Node<E>? = null

    var tail: Node<E>? = null

    data class Node<E>(var value: E, var previous: Node<E>? = null, var next: Node<E>? = null) {override fun toString(): String { return value.toString()}}

    override fun size(): Int {
        return size
    }

    @Throws(NoSuchElementException::class)
    override fun peek(): E {
        if (size == 0) throw NoSuchElementException()

        return head!!.value
    }

    @Throws(NoSuchElementException::class)
    override fun pop(): E {
        if (size == 0) throw NoSuchElementException()

        val result: E = getFirst()!!
        deleteFirst()

        return result
    }

    override fun push(element: E) {
        addFirst(element)
    }

    override fun addLast(element: E) {
        append(element)
    }

    override fun enqueue(element: E) {
        addLast(element)
    }

    @Throws(NoSuchElementException::class)
    override fun dequeue(): E {
        if (size == 0) throw NoSuchElementException()

        val result: E = getFirst()!!
        deleteFirst()

        return result
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
            currentNode = currentNode.next
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

    fun reverseFromHead() {
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

        while (curNode != null) {

            if (prevNode.previous == null) {
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

    private fun swapHeadAndTail() {
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

    fun findKFromEnd(k: Int): E {
        assert(size >= k) { "list size should be greater than k" }

        var node = head
        var fastNode = head
        var idx = 0

        // move fast node to k position
        while (idx < k) {
            fastNode = fastNode!!.next
            idx++
        }

        while (fastNode!!.next != null) {
            node = node!!.next
            fastNode = fastNode.next
        }

        return node!!.value
    }

    /*
    * Will create endless loop, so be very careful!!!
     */
    fun createLoop() {
        tail!!.next = head
    }

    fun containsLoop(): Boolean {
        if (size <= 1) return false

        var slowNode = head
        var fastNode = head

        while (fastNode!!.next != null && fastNode!!.next!!.next != null) {
            slowNode = slowNode!!.next
            fastNode = fastNode!!.next!!.next

            if (slowNode == fastNode) return true
        }
        return false
    }

    fun partition(partition: E) {
        assert(size > 2) { "partitioning should work with list with size greater than 2" }


        var prevNode = head
        var curNode = head!!.next
        var nextNode = curNode!!.next

        repeat(size - 1) {
            if (curNode!!.value < partition) {
                prevNode!!.next = nextNode
                nextNode!!.previous = prevNode
                size--

                addFirst(curNode!!.value)

                curNode = nextNode
                nextNode = curNode!!.next
            } else if (curNode!!.value > partition) {
                prevNode!!.next = nextNode
                nextNode!!.previous = prevNode
                size--

                addLast(curNode!!.value)

                curNode = nextNode
                nextNode = curNode!!.next
            } else {
                prevNode = curNode
                curNode = nextNode
                nextNode = nextNode!!.next
            }
        }
    }


}
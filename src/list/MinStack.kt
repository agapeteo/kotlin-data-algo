package list

class MinStack<E : Comparable<E>> : Stack<E> {

    private val regularStack = DefaultLinkedList<E>()
    private val minStack = DefaultLinkedList<E>()

    override fun peek(): E {
        return regularStack.peek()
    }

    override fun pop(): E {
        val result = regularStack.pop()

        if (result == minStack.peek()) {
            minStack.pop()
        }

        return result
    }

    override fun push(element: E) {
        if (minStack.size() == 0 || element < minStack.peek()) {
            minStack.push(element)
        }
        return regularStack.push(element)
    }

    fun min(): E {
        return minStack.peek()
    }

}
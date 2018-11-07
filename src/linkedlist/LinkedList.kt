package linkedlist

interface LinkedList<out E> {

    fun elementByIndex(index: Int): E

    fun append(element: @UnsafeVariance E)

    fun deleteLast()

    fun addFirst(element: @UnsafeVariance E)

    fun deleteFirst()

    fun elements(): Collection<E>

    fun firstIndexOf(element: @UnsafeVariance E): Int

    fun insertAfterIndex(index: Int, element: @UnsafeVariance E)

    fun addLast(element: @UnsafeVariance E)

    fun get(index: Int): E

    fun getFirst(): E?

    fun getLast(): E?

    fun size(): Int
}
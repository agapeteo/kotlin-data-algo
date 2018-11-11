package list

interface Queue<E> {

    fun enqueue(element: E)

    @Throws(NoSuchElementException::class)
    fun dequeue(): E

}
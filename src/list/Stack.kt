package list

interface Stack<E : Any?> {

    @Throws(NoSuchElementException::class)
    fun peek(): E

    @Throws(NoSuchElementException::class)
    fun pop(): E

    fun push(element: E)

}
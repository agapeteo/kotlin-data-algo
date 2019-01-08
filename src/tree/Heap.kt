package tree

interface Heap<E : Comparable<E>> {

    fun peek(): E
    fun pop(): E
    fun push(value: E)

    fun elements(): List<E>
    fun size(): Int
}
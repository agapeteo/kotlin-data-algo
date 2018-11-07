package tree

interface BinarySearchTree<E : Comparable<E>> {
    fun add(value: E)
    fun elements(): List<E>
    fun contains(value: E): Boolean
    fun orderedElements(): List<E>
    fun depth(): Int
}
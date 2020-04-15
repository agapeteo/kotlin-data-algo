package graph

interface DisjointSet<E> {
    fun union(left: E, right: E);

    fun find(elem: E): E  // result root element of set

    fun connected(left: E, right: E): Boolean
}
package list

private class CacheList<K, V>(var head: CacheNode<K, V>? = null, var tail: CacheNode<K, V>? = null) {
    fun addLast(node: CacheNode<K, V>) {
        if (handleEmpty(node)) {
            return
        }
        val curTail = tail
        curTail!!.next = node
        node.prev = curTail
        tail = node
    }

    fun handleEmpty(node: CacheNode<K, V>): Boolean {
        if (head != null) {
            return false
        }
        head = node
        tail = node
        return true
    }

    fun remove(node: CacheNode<K, V>?) {
        if (node == null) {
            return
        }
        val prevNode = node.prev
        val nextNode = node.next

        if (prevNode != null) {
            prevNode.next = nextNode
        }
        if (nextNode != null) {
            nextNode.prev = prevNode
        }
        if (head == node) {
            head = nextNode
        }
        if (tail == node) {
            tail = prevNode
        }
    }

    fun head(): CacheNode<K, V>? {
        return head
    }
}

private class CacheNode<K, V>(val key: K, val value: V, var next: CacheNode<K, V>? = null, var prev: CacheNode<K, V>? = null)

class CacheLru<K, V>(private val capacity: Int) {
    private val cache = mutableMapOf<K, CacheNode<K, V>>()
    private val queue = CacheList<K, V>()

    fun put(key: K, value: V) {
        val existingNode = cache[key]
        if (existingNode != null) {
            queue.remove(existingNode)
            cache.remove(existingNode.key)
        }
        val newNode = CacheNode(key, value)
        queue.addLast(newNode)
        cache[key] = newNode

        if (cache.size > capacity) {
            val nodeToDelete = queue.head()

            if (nodeToDelete != null) {
                queue.remove(nodeToDelete)
                cache.remove(nodeToDelete.key)
            }
        }
    }

    fun get(key: K): V? {
        val foundNode = cache[key]

        if (foundNode != null) {
            queue.remove(foundNode)
            queue.addLast(foundNode)
        }
        return foundNode?.value
    }

    fun size(): Int {
        return cache.size
    }
}
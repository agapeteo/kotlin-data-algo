package map

import java.util.*


class HashMap<K, V>(initSize: Int = 16, private val loadFactor: Double = 0.75) : Map<K, V> {

    data class Entry<K, V>(val key: K, var value: V)
    data class EntryList<K, V>(val entries: LinkedList<Entry<K, V>>)

    private var buckets: MutableList<EntryList<K, V>> = mutableListOf()
    private var entries = 0

    init {
        for (i in 0 until initSize){
            buckets.add(EntryList(LinkedList()))
        }
    }

    override fun put(key: K, value: V): V? {
        val entryList = buckets[indexFor(key)]

        val entryToReplace: Entry<K, V>? = entryList.entries.firstOrNull{ key == it.key }

        var result: V? = null

        if (entryToReplace != null){
            result = entryToReplace.value
            entryToReplace.value = value
        } else {
            entryList.entries.add(Entry(key, value))
            entries++

            if ( entries.toDouble() / buckets.size > loadFactor) resize()
        }
        return result
    }

    private fun resize() {
        val newSize = buckets.size * 2
        val newBuckets: MutableList<EntryList<K, V>> = mutableListOf()

        for (i in 0 until newSize){
            newBuckets.add(EntryList(LinkedList()))
        }

        entries().forEach { entry ->
            val entryList = newBuckets[indexFor(entry.key, newSize)]
            entryList.entries.add(entry)
        }

        buckets = newBuckets
    }

    private fun indexFor(key: K, size: Int = buckets.size): Int {
        return key.hashCode() and 0x7fffffff % size // which is more effective than // Math.abs(key.hashCode()) % size
    }

    override fun get(key: K): V? {
        val entryList = buckets[indexFor(key)]

        return entryList.entries.firstOrNull { key == it.key }?.value
    }

    override fun size(): Int {
        return buckets.size
    }

    override fun entries(): List<Entry<K, V>>{
        val result = mutableListOf<Entry<K, V>>()

        buckets.forEach { it.entries.forEach { entry -> result.add(entry) } }

        return result
    }
}
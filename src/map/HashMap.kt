package map

import java.util.*


class HashMap<K, V> : Map<K, V> {

    data class Entry<K, V>(val key: K, var value: V)

    data class EntryList<K, V>(val entries: LinkedList<Entry<K, V>>)

    private val buckets: MutableList<EntryList<K, V>>

    init {
        val initSize = 16

        buckets = mutableListOf()

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
        }
        return result
    }

    private fun indexFor(key: K): Int {
        return key.hashCode() and 0x7fffffff % buckets.size // which is more effective than // Math.abs(key.hashCode()) % buckets.size
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
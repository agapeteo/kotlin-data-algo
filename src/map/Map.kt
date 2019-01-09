package map

interface Map<K, V> {

    fun put(key: K, value: V): V?

    fun get(key: K): V?

    fun size(): Int

    fun entries(): List<HashMap.Entry<K, V>>
}
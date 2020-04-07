package list

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CacheLruTest {

    @Test
    fun basic() {
        val cache = CacheLru<Int, String>(2)

        cache.put(1, "one")
        cache.put(2, "two")

        assertEquals("one", cache.get(1))

        cache.put(3, "three");    // evicts key 2

        assertEquals(null, cache.get(2))

        cache.put(4, "four");    // evicts key 1
        assertEquals(null, cache.get(1))

        assertEquals("three", cache.get(3))
        assertEquals("four", cache.get(4))
    }

    @Test
    fun `update value for same key`() {
        val cache = CacheLru<Int, String>(3)

        assertEquals(null, cache.get(0))
        cache.put(0, "0")
        assertEquals("0", cache.get(0))

        cache.put(0, "zero")
        assertEquals("zero", cache.get(0))
    }
}
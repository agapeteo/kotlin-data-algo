package map

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HashMapTest {

    @Test
    fun `simple map test`() {
        // given
        val map = HashMap<Int, String>()

        // when
        for (i in 0 until 100){
            map.put(i, i.toString())
        }

        map.put(1, "one")

        // then
        assertEquals(map.get(1), "one")
        assertEquals(map.get(9), "9")
        assertEquals(map.get(20), "20")
        assertEquals(map.get(200), null)

        assertEquals(map.entries().size, 100)
    }
}
package graph

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SimpleDisjointSetTest {

    @Test
    fun simple() {
        val dset = SimpleDisjointSet<String>()

        dset.union("A", "B")
        dset.union("B", "C")
        dset.union("C", "D")
        dset.union("A", "D")

        assertEquals(true, dset.connected("A", "B"))
        assertEquals(true, dset.connected("A", "C"))
        assertEquals(true, dset.connected("A", "D"))
        assertEquals(true, dset.connected("C", "A"))
        assertEquals(true, dset.connected("C", "D"))

        dset.union("AA", "BB")
        dset.union("BB", "CC")

        assertEquals(false, dset.connected("A", "AA"))
        assertEquals(false, dset.connected("BB", "A"))

        assertEquals(true, dset.connected("AA", "BB"))
        assertEquals(true, dset.connected("CC", "AA"))

        dset.union("AAA", "BBB")
        dset.union("AAA", "DDD")
        dset.union("AAA", "CCC")

        assertEquals(false, dset.connected("A", "AA"))
        assertEquals(false, dset.connected("AA", "AAA"))
        assertEquals(false, dset.connected("D", "DDD"))

        assertEquals(true, dset.connected("DDD", "AAA"))
        assertEquals(true, dset.connected("AAA", "BBB"))

        dset.union("C", "CCC")

        assertEquals(true, dset.connected("A", "AAA"))
        assertEquals(true, dset.connected("C", "DDD"))

        assertEquals(false, dset.connected("C", "AA"))
        assertEquals(false, dset.connected("A", "CC"))

        dset.union("BBB", "BB")
        assertEquals(true, dset.connected("C", "AA"))
        assertEquals(true, dset.connected("A", "CC"))

        assertEquals(true, dset.connected("A", "A"))
        assertEquals(true, dset.connected("A", "AA"))
        assertEquals(true, dset.connected("A", "AAA"))
        assertEquals(true, dset.connected("B", "B"))
        assertEquals(true, dset.connected("B", "BB"))
        assertEquals(true, dset.connected("B", "BBB"))

        assertEquals(true, dset.connected("A", "B"))
        assertEquals(true, dset.connected("B", "AA"))
        assertEquals(true, dset.connected("AAA", "C"))
    }
}
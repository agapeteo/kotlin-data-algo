package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PowerSetTest {

    @Test
    fun powerSet() {
        println(PowerSet.powerSet(listOf(1, 2, 3)))
    }

}
package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoinsNotRecursiveExperimentTest {

    @Test
    fun coinsTimes() {
//        println(CoinsNotRecursiveExperiment.coinsTimes(100, intArrayOf(50, 25)))
//        assertEquals(3,  CoinsNotRecursiveExperiment.coinsTimes(75, intArrayOf(50, 25)))
        assertEquals(9,  CoinsNotRecursiveExperiment.coinsTimes(100, intArrayOf(50, 20)))
    }
}
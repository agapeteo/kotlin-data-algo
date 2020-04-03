
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubsetSumKtTest {

    @Test
    fun `16`() {
//        val numbers = arrayOf(2, 4, 6, 10)
        val numbers = arrayOf(2, 4, 5)
//        val numbers = arrayOf(2, 4)
//        val sum = 17
        val sum = 10
        val subsetSum = SubsetSum()
        val actual = subsetSum.isSubsetSum(numbers.toIntArray(),numbers.size, sum)
        println(actual)
        println("traceCalls ${subsetSum.visual.traceCalls}")
//        println("sequence: ${subsetSum.visual.buildSequence()}")
        println("sequence: ${subsetSum.visual.buildTextSequence()}")
    }
}
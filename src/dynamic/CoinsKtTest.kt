import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoinsKtTest {

    @Test
    fun coinChangeWays() {
        val coins = Coins()
//        val actual = coins.coinChangeWays(100, listOf(25, 10, 5, 1))
//        val actual = coins.coinChangeWays(50, listOf(10, 5, 1))
        val actual = coins.coinChangeWays(5, listOf(1,2,3))
        println(actual)
        println(coins.visual.traceCalls)
        println(coins.visual.buildTextSequence())
        println(coins.visual.buildSequence())
    }

    @Test
    fun coinChangeWays__() {
        val coins = Coins()
//        val actual = coins.coinChangeWays(100, listOf(25, 10, 5, 1))
//        val actual = coins.coinChangeWays(50, listOf(10, 5, 1))
        val actual = coins.coinChangeWays(100, listOf(50, 20))
//        val actual = coins.coinChangeWays(100, listOf(50, 25))
        println(actual)
        println(coins.visual.traceCalls)
        println(coins.visual.buildTextSequence())
        println(coins.visual.buildSequence())
    }
}
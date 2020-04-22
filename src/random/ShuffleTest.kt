package random

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShuffleTest {

    @Test
    fun shuffle() {
        val list = mutableListOf(1, 2, 3, 4, 5, 6, 7)

        Shuffle.shuffle(list)

        println(list)
    }
}
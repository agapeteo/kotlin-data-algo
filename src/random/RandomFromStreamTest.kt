package random

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RandomFromStreamTest {

    @Test
    fun random() {
        val list = listOf("A", "B", "C", "D", "E")
        val counts = mutableMapOf<String, Int>()

        for (i in 0..1000_000) {
            val randomLetter = RandomFromStream.random(list.stream())
            var curCount = counts[randomLetter]
            if (curCount == null) {
                counts[randomLetter!!] = 1
            } else {
                counts[randomLetter!!] = curCount + 1
            }
        }

        println(counts)
    }
}
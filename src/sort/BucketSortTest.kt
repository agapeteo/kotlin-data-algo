package sort

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BucketSortTest {

    @Test
    fun sort() {
        val numbers = mutableListOf(10.0, 9.0, 1.0, 8.0)

        val actual = BucketSort.sort(numbers)

        assertEquals(listOf(1.0, 8.0, 9.0, 10.0), actual)
    }

    @Test
    fun `sortRange 2500-500`() {
        val numbers = mutableListOf<Double>()

        for (i in (500..2500).reversed()) {
            numbers.add(i.toDouble())
        }

        val actual = BucketSort.sort(numbers)

        for ((idx, n) in (500..2500).withIndex()) {
            assertEquals(n.toDouble(), actual[idx])
        }
    }

    @Test
    fun `sortRange 100-0 and odd and even`() {
        val numbers = mutableListOf<Double>()

        for (i in (0..100).reversed()) {
            if (i % 2 == 0) continue
            numbers.add(i.toDouble())
        }

        for (i in (0..100).reversed()) {
            if (i % 2 != 0) continue
            numbers.add(i.toDouble())
        }

        val actual = BucketSort.sort(numbers)

        for ((idx, n) in (0..100).withIndex()) {
            assertEquals(n.toDouble(), actual[idx])
        }
    }

    @Test
    fun `sortRange 10-100`() {
        val numbers = mutableListOf<Double>()

        for (i in (10..100)) {
            numbers.add(i.toDouble())
        }

        val actual = BucketSort.sort(numbers)

        for ((idx, n) in (10..100).withIndex()) {
            assertEquals(n.toDouble(), actual[idx])
        }
    }
}
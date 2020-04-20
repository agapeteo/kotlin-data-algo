package sort

import kotlin.math.pow

object RadixSort {
    private const val BASE = 10

    fun sort(list: List<Int>): List<Int> {
        var result = list

        if (list.size < 2) return result

        val digitsCount = countDigits(list.max()!!)

        for (digitLevel in 0 until digitsCount) {
            result = sortAtLevel(result, digitLevel)
        }
        return result
    }

    private fun countDigits(maxNumber: Int): Int {
        var digits = 0
        var number = maxNumber

        while (number != 0) {
            number /= 10
            digits += 1
        }
        return digits
    }

    private fun sortAtLevel(numbers: List<Int>, digitLevel: Int): List<Int> {
        var buckets = tenEmptyDigitBuckets()

        for (number in numbers) {
            val bucketIdx = (number / tenInPow(digitLevel)) % BASE

            buckets[bucketIdx].add(number)
        }

        val result = mutableListOf<Int>()
        for (bucket in buckets) {
            result.addAll(bucket)
        }
        return result
    }

    private fun tenInPow(digitLevel: Int): Int {
        return (BASE.toDouble()).pow(digitLevel).toInt()
    }

    private fun tenEmptyDigitBuckets(): List<MutableList<Int>> {
        var buckets = mutableListOf<MutableList<Int>>()
        for (i in 0..BASE) {
            buckets.add(mutableListOf())
        }
        return buckets
    }
}
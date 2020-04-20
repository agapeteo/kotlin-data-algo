package sort

import kotlin.math.sqrt

object BucketSort {

    fun sort(numbers: MutableList<Double>): List<Double> {
        if (numbers.size < 2) return numbers

        val minNumber = numbers.min()!!
        val range = numbers.max()!! - minNumber
        val bucketsCount = sqrt(range).toInt()
        val buckets = emptyBuckets(bucketsCount)

        for (number in numbers) {
            val curBucketIdx = (number - minNumber) * bucketsCount / range
            buckets[curBucketIdx.toInt()].add(number)
        }

        val result = mutableListOf<Double>()

        for (bucket in buckets) {
            val sortedBucket = BucketSort.sort(bucket)
            result.addAll(sortedBucket)
        }
        return result
    }

    private fun emptyBuckets(count: Int): List<MutableList<Double>> {
        var buckets = mutableListOf<MutableList<Double>>()
        for (i in 0..count) {
            buckets.add(mutableListOf())
        }
        return buckets
    }
}
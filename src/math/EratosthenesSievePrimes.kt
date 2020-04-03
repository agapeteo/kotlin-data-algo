package math

import kotlin.math.sqrt

object EratosthenesSievePrimes {

    fun primes(limit: Int): List<Int> {
        val arr = BooleanArray(limit)

        for (i in 2 until sqrt(limit.toDouble()).toInt()) {
            if (arr[i]) continue

            var j = i + i
            while (j < limit) {
                arr[j] = true
                j += i
            }
        }
        val result = mutableListOf<Int>()
        for ((num, notPrime) in arr.withIndex()) {
            if (num == 0 || num == 1) continue
            if (!notPrime) {
                result.add(num)
            }
        }
        return result
    }
}
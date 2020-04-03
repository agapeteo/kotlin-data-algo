package math

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EratosthenesSievePrimesTest {

    @Test
    fun primes() {
        println(EratosthenesSievePrimes.primes(100))
    }
}
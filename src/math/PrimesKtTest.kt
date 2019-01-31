package math

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PrimesKtTest {

    @Test
    fun isPrime() {
        assertTrue(Primes.isPrime(11))
        assertTrue(Primes.isPrime(13))
        assertTrue(Primes.isPrime(23))
        assertTrue(Primes.isPrime(31))

        assertFalse(Primes.isPrime(10))
        assertFalse(Primes.isPrime(12))
        assertFalse(Primes.isPrime(20))
        assertFalse(Primes.isPrime(21))
    }
}
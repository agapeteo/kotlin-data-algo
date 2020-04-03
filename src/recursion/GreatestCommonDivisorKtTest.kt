package recursion

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GreatestCommonDivisorKtTest {

    @Test
    fun gcd() {
        assertEquals(4, gcd(8, 12))
    }
}
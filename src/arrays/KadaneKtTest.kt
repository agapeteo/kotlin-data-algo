package arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class KadaneKtTest {

    @Test
    fun maxSum_1() {
        assertEquals(maxSum(listOf(-1, 2, 3, -7, 3, 4)), 7);
    }

    @Test
    fun maxSum_2() {
        assertEquals(maxSum(listOf(34, -50, 42, 14, -5, 86)), 137);
    }
}
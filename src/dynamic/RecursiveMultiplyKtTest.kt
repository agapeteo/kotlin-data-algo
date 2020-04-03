package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RecursiveMultiplyKtTest {

    @Test
    fun minProduct() {
        assertEquals(25, productOf(5, 5))
        assertEquals(6, productOf(2, 3))
        assertEquals(12, productOf(6, 2))
        assertEquals(5, productOf(5, 1))
    }
}
package bits

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BitManipulationsKtTest {

    @Test
    fun `2 in binary`() {
        assertEquals(2, BitManipulations.twoInBinary())
    }

    @Test
    fun `number to String`() {
        assertEquals("111", BitManipulations.numberToBinaryStr(7))
    }

    @Test
    fun `get bit`() {
        assertTrue(BitManipulations.checkBit(2, 0b101))
        assertFalse(BitManipulations.checkBit(1, 0b101))
    }

    @Test
    fun `set bit`() {
        assertEquals(0b111, BitManipulations.setBit(1, 0b101))
    }

    @Test
    fun `clear bit`() {
        assertEquals(0b101, BitManipulations.clearBit(1, 0b111))
    }

    @Test
    fun `toggle bit`() {
        assertEquals(0b101, BitManipulations.toggleBit(1, 0b111))
        assertEquals(0b111, BitManipulations.toggleBit(1, 0b101))
    }

    @Test
    fun isOdd() {
        assertFalse(BitManipulations.isEven(1))
        assertFalse(BitManipulations.isEven(3))
        assertTrue(BitManipulations.isEven(2))
        assertTrue(BitManipulations.isEven(10))
    }
}
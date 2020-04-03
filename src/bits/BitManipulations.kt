package bits

object BitManipulations {
    fun twoInBinary(): Int {
        return 0b10
    }

    fun numberToBinaryStr(number: Int): String {
        return number.toString(2)
    }

    fun checkBit(idx: Int, number: Int): Boolean {
        return number and (1 shl idx) != 0
    }

    fun setBit(idx: Int, number: Int): Int {
        return number or (1 shl idx)
    }

    fun clearBit(idx: Int, number: Int): Int {
        val mask = (1 shl idx).inv()
        return number and mask
    }

    fun toggleBit(idx: Int, number: Int): Int {
        return number xor (1 shl idx)
    }

    fun isEven(number: Int): Boolean {
        return (1 and number) == 0
    }
}
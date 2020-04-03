package math

object ReverseIntDigits {
    private const val BASE = 10

    fun reverse(value: Int): Int {
        if (value == 0) return 0
        val negative = value < 0
        val digits = mutableListOf<Int>()
        var intValue = value
        while (intValue != 0) {
            digits.add(intValue % BASE)
            intValue /= BASE
        }
        var result = 0
        for (i in 0 until digits.size) {
            var tenInPower = 1
            if (i != digits.size - 1) {
                for (j in 0 until digits.size - i - 1) {
                    tenInPower *= 10
                }
            }
            result += digits[i] * tenInPower
        }

        return if (negative) -result.unaryMinus() else result
    }
}
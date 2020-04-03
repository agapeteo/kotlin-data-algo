package bits

import java.lang.StringBuilder



fun toBinary(number: Double, precision: Int = 2): String{
    val wholePart = number.toLong()
    return "${wholePart.toString(2)}.${fractionalToBinary(number - wholePart.toDouble(), precision)}"
}

fun fractionalToBinary(numberParameter: Double, precision: Int): String {
    val result = StringBuilder()
    var number = numberParameter
    while (number > 0 && result.length < precision) {
        val r = number * 2
        number = if (r >= 1) {
            result.append(1)
            r - 1
        } else {
            result.append(0)
            r
        }
    }
    return result.toString()
}


fun main() {
    println(toBinary(10.5))
}
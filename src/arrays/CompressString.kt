package arrays

import java.lang.StringBuilder

fun compressString(str: String): String {
    val chars = str.toCharArray()

    val result = StringBuilder()

    var i = 0
    var j = i + 1

    while (j < str.length) {
        if (chars[j] != chars[i]) {
            result.append(chars[i]).append(j - i)
            if (result.length > str.length) {
                return str
            }
            i = j
        }
        j++
    }
    result.append(chars[i]).append(j - i)


    return result.toString()
}
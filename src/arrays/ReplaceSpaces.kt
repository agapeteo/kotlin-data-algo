package arrays

fun replaceSpaces(charArray: Array<Char?>, length: Int) {
    var spaceCount = 0

    for (i in 0 until length) {
        if (charArray[i] == ' ') spaceCount++
    }

    var newLength = length + spaceCount * 2
//    charArray[newLength] = '?'

    for (i in (length - 1) downTo 0) {
        if (charArray[i] == ' ') {
            charArray[newLength - 1] = '0'
            charArray[newLength - 2] = '2'
            charArray[newLength - 3] = '%'
            newLength -= 3
        } else {
            charArray[newLength - 1] = charArray[i]
            newLength -= 1
        }
    }


}
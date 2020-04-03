package arrays

fun isEditDistanceGreaterThan1(str1: String, str2: String): Boolean {
    val biggerStr = if (str1.length > str2.length) str1 else str2
    val smallerStr = if (biggerStr == str1) str2 else str1

    val sizeDiff = biggerStr.length - smallerStr.length;
    if (sizeDiff > 1) return false

//    var diffCount = sizeDiff
    var diffCount = 0

    var bigIdx = 0
    var smallIdx = 0

    while (bigIdx < biggerStr.length) {
        if (smallIdx >= smallerStr.length || biggerStr[bigIdx] != smallerStr[smallIdx]) {
            diffCount++
            if (diffCount > 1) return false
            bigIdx++
            continue
        }
        bigIdx++
        smallIdx++
    }

    return true
}
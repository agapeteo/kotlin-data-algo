package arrays

fun maxSum(list: List<Int>): Int {
    var result = 0
    var curSum = 0

    for (i in list.indices) {
        if (curSum + list[i] > 0) {
            curSum += list[i]
            if (curSum > result) {
                result = curSum
            }
        } else {
            curSum = 0
        }
    }
    return result
}
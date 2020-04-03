package arrays

object KadanesMaxSubArraySum {

    data class Result(val maxSum: Int, val startIdx: Int, val endIdx: Int)

    fun maxSum(list: List<Int>): Result {
        var maxSum = 0
        var curSum = 0
        var startIdx = 0
        var endIdx = 0

        for ((idx, num) in list.iterator().withIndex()) {
            if (curSum <= 0) {
                startIdx = idx
                curSum = num
            } else {
                curSum += num
            }
            if (curSum > maxSum) {
                maxSum = curSum
                endIdx = idx
            }
        }
        if (startIdx > endIdx) {
            startIdx = endIdx
            endIdx = startIdx
        }
        return Result(maxSum, startIdx, endIdx + 1)
    }
}
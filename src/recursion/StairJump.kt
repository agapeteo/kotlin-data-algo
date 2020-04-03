package recursion

object StairJump {

    fun waysCount(stairsCount: Int, jumpWays: IntArray): Int {
        if (stairsCount < 0) return 0

        if (stairsCount == 0) return 1

        var totalCount = 0;

        for (jumpStairsWay in jumpWays) {
            totalCount += waysCount(stairsCount - jumpStairsWay, jumpWays)
        }
        return totalCount;
    }
}
package dynamic

object StairJump {

    fun waysCount(stairsCount: Int, jumpWays: IntArray, cache: Array<Int?> = arrayOfNulls<Int?>(stairsCount + 1)): Int {
        if (stairsCount < 0) return 0

        if (stairsCount == 0) return 1

        var totalWays = 0

        for (curJump in jumpWays) {
            val curWaysCountIdx = stairsCount - curJump

            if (curWaysCountIdx < 0) continue

            var curJumpWays = cache[curWaysCountIdx]
            if (curJumpWays == null) {
                curJumpWays = waysCount(curWaysCountIdx, jumpWays, cache)
                cache[curWaysCountIdx] = curJumpWays
            }
            totalWays += curJumpWays
        }
        return totalWays
    }
}
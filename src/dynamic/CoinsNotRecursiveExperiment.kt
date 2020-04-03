package dynamic

import java.util.*

object CoinsNotRecursiveExperiment {

    fun coinsTimes(totalAmount: Int, coins: IntArray): Int {
        fun printCoins(amount: Int) {
            var i = coins.size - 1

            var leftAmount = amount;
            while(i >= 0) {
                val count = leftAmount / coins[i]
                if (count != 0) {
                    print("${coins[i]}x$count ")
                }
                leftAmount = totalAmount - coins[i] * count
                i--
            }
            print("\n")
        }

        val task = CoinsTask(0, totalAmount)
        val stack = LinkedList<CoinsTask>()
        stack.push(task)
        var totalCount = 0

        while (stack.isNotEmpty()) {
            val curTask = stack.pop()

            if (curTask.denomIdx == coins.size - 1) {
                totalCount++
                printCoins(curTask.amount)
                continue
            }

            var count = 0
            while (curTask.amount - coins[curTask.denomIdx] * count >= 0) {
                stack.push(CoinsTask(curTask.denomIdx + 1, curTask.amount - coins[curTask.denomIdx] * count))

                count++
            }
        }

        return totalCount
    }


}

data class CoinsTask(val denomIdx: Int, var amount: Int)
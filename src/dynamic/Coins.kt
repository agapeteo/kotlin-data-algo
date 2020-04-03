
import visual.*

class Coins(val visual: VisualFunction = BasicVisualFunction()) {

    fun coinChangeWays(amount: Int, denoms: List<Int>, denomIdx: Int = 0): Int {
        visual.enter("coinChangeWays", "amount: $amount, denomidx: $denomIdx denomAmount: ${denoms[denomIdx]}")

        if (denomIdx >= denoms.size - 1) {
            visual.exit("1, amount $amount denomIdx $denomIdx")

            println("--> amount: $amount, denomIdx: $denomIdx")
            return 1
        }

        val denomAmount = denoms[denomIdx]
        var ways = 0

        var i = 0
        while (i * denomAmount <= amount) {
            val remainingAmount = amount - i * denomAmount
            ways += coinChangeWays(remainingAmount, denoms, denomIdx + 1)
            i++
        }
        visual.exit("end")
        return ways
    }
}
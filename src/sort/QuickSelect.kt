package sort

object QuickSelect {
    fun <T : Comparable<T>> top(topIdx: Int, list: MutableList<T>, lowIdx: Int = 0, hiIdx: Int = list.size - 1): T {
        fun swap(i: Int, j: Int) {
            val tmp = list[i]
            list[i] = list[j]
            list[j] = tmp
        }

        var i = lowIdx
        val pivotValue = list[hiIdx]
        for (j in i until hiIdx) {
            if (list[j] <= pivotValue) {
                swap(i, j)
                i++
            }
        }
        swap(hiIdx, i)

        if (i != topIdx) {
            if (topIdx < i) {
                return top(topIdx, list, lowIdx, i - 1) // go left
            }
            return top(topIdx, list, i + 1, topIdx) // go right
        }
        return list[i]
    }
}
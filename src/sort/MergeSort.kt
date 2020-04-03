package sort

import visual.*


class MergeSort<T : Comparable<T>>(val visual: VisualFunction = BasicVisualFunction()) {

    fun sort(list: MutableList<T>, lowIdx: Int = 0, highIdx: Int = list.size -1): List<T> {
        visual.enter("sort", "lowIdx: $lowIdx highIdx: $highIdx")

        if (lowIdx == highIdx) {
            visual.exit()
            return listOf(list[lowIdx])
        }

        if (lowIdx > highIdx) {
            visual.exit()
            return listOf()
        }

        val mid = (lowIdx + highIdx) / 2
        val left = sort(list, lowIdx, mid)
        val right = sort(list, mid + 1, highIdx)

        visual.exit()
        return merge(left, right)
    }

    private fun merge(left: List<T>, right: List<T>): List<T> {
        visual.enter("merge", "left: $left right: $right")

        val result = mutableListOf<T>()

        var leftIdx = 0
        var rightIdx = 0

        while (leftIdx < left.size && rightIdx < right.size) {
            if (left[leftIdx] <= right[rightIdx]) {
                result.add(left[leftIdx])
                leftIdx++
            } else {
                result.add(right[rightIdx])
                rightIdx++
            }
        }

        if (rightIdx <= right.size - 1) {
            for (i in rightIdx until right.size) {
                result.add(right[i])
            }
        } else {
            for (i in leftIdx until left.size) {
                result.add(left[i])
            }
        }

        visual.exit()
        return result
    }

}
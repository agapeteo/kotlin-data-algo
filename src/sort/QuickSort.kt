package sort

import visual.*

class QuickSort<T : Comparable<T>>(val visual: VisualFunction = BasicVisualFunction()) {

    fun sort(list: MutableList<T>, leftIdx: Int = 0, rightIdx: Int = list.size - 1) {
        visual.enter("sort", "leftIdx: $leftIdx rightIdx: $rightIdx")

        if (leftIdx >= rightIdx) {
            visual.exit()
            return
        }

        val index = partition(list, leftIdx, rightIdx)
        if (index > leftIdx) sort(list, index - 1, rightIdx)
        if (index < rightIdx) sort(list, index + 1, rightIdx)

        visual.exit()
    }

    private fun partition(list: MutableList<T>, leftIdx: Int, rightIdx: Int): Int {
        visual.enter("partition", "leftIdx: $leftIdx rightIdx: $rightIdx")

        var curLeft = leftIdx
        var curRight = rightIdx
        val partition = list[(leftIdx + rightIdx) / 2]

        while (curLeft < curRight) {

            while (list[curLeft] < partition) curLeft++
            while (list[curRight] > partition) curRight--

            if (curLeft <= curRight) {
                val tmp = list[curLeft]
                list[curLeft] = list[curRight]
                list[curRight] = tmp

                curLeft++
                curRight--
            }
        }
        visual.exit()
        return leftIdx
    }

}
// simplest solution but not in-place
//fun <T : Comparable<T>> quicksort(items: List<T>): List<T> {
//    if (items.count() < 1) return items
//    val pivot = items[items.count() / 2]
//    val equal = items.filter { it == pivot }
//    val less = items.filter { it < pivot }
//    val greater = items.filter { it > pivot }
//    return quicksort(less) + equal + quicksort(greater)
//}
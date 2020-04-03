package sort

import java.util.ArrayList


fun <T : Comparable<in T>> mergeSort(
        listToSort: MutableList<T>,
        tmpList: MutableList<T> = ArrayList(listToSort),
        lowIdx: Int = 0, highIdx: Int = listToSort.size - 1) {

    if (lowIdx >= highIdx || listToSort.size < 2) return

    val middleIdx = lowIdx + (highIdx - lowIdx) / 2
    mergeSort(listToSort, tmpList, lowIdx, middleIdx) //  sort left side
    mergeSort(listToSort, tmpList, middleIdx + 1, highIdx) // sort right side

    merge(listToSort, tmpList, lowIdx, middleIdx, highIdx) // merge sorted from left and right sides
}

private fun <T : Comparable<T>> merge(listToSort: MutableList<T>, tmpList: MutableList<T>, lowIdx: Int, middleIdx: Int, highIdx: Int) {
    for (i in lowIdx..highIdx) {
        tmpList[i] = listToSort[i]
    }

    var leftIdx = lowIdx
    var rightIdx = middleIdx + 1
    var curIdx = leftIdx

    while (leftIdx <= middleIdx && rightIdx <= highIdx) {
        if (tmpList[leftIdx] <= (tmpList[rightIdx])) {
            listToSort[curIdx] = tmpList[leftIdx]
            leftIdx++
        } else {
            listToSort[curIdx] = tmpList[rightIdx]
            rightIdx++
        }
        curIdx++
    }

    val remainingCount = middleIdx - leftIdx
    for (i in 0..remainingCount) {
        listToSort[curIdx + i] = tmpList[leftIdx + i]
    }
}

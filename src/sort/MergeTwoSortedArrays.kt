package sort

fun <T : Comparable<T>> mergeArrays(left: Array<T>, bufferStartIdx: Int, right: Array<T>) {
    var leftIdx = 0
    var rightIdx = 0
    var curBufferStartIdx = bufferStartIdx

    while (leftIdx < curBufferStartIdx && rightIdx < right.size) {

        while (left[leftIdx] <= right[rightIdx]) {
            if (leftIdx == bufferStartIdx) break
            leftIdx++
        }

        System.arraycopy(left, leftIdx, left, leftIdx + 1, curBufferStartIdx - leftIdx)
        left[leftIdx] = right[rightIdx]

        curBufferStartIdx++
        leftIdx++
        rightIdx++
    }

    if (leftIdx == curBufferStartIdx) {
        System.arraycopy(right, rightIdx, left, curBufferStartIdx, right.size - rightIdx)
    }
}

package sort

class HoareQuickSort {
    companion object {
        fun <T : Comparable<in T>> sort(array: Array<T>, lowIdx: Int = 0, highIdx: Int = array.size - 1) {
            if (array.size < 2 || lowIdx >= highIdx) return

            val partitionIdx = partition(array, lowIdx, highIdx)
            sort(array, lowIdx, partitionIdx - 1)
            sort(array, partitionIdx + 1, highIdx)
        }

        private fun <T : Comparable<in T>> partition(array: Array<T>, lowIdx: Int, highIdx: Int): Int {
            val pivotValue = array[lowIdx]
            var leftIdx = lowIdx
            var rightIdx = highIdx + 1

            while (true) {
                do {
                    leftIdx++
                    if (leftIdx == highIdx) break
                } while (array[leftIdx] < pivotValue)

                do {
                    rightIdx--
                    if (rightIdx == lowIdx) break
                } while (array[rightIdx] > pivotValue)

                if (leftIdx >= rightIdx) break

                swap(array, leftIdx, rightIdx)
            }

            swap(array, lowIdx, rightIdx)
            return rightIdx
        }

        private fun <T> swap(array: Array<T>, i: Int, j: Int) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }
    }
}
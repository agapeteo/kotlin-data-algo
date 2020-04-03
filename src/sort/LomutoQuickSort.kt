package sort

class LomutoQuickSort {
    companion object {
        fun <T : Comparable<in T>> sort(array: Array<T>, lowIdx: Int = 0, highIdx: Int = array.size - 1) {
            if (array.size < 2 || lowIdx >= highIdx) return

            val partitionIdx = partition(array, lowIdx, highIdx)
            sort(array, lowIdx, partitionIdx - 1)
            sort(array, partitionIdx + 1, highIdx)
        }

        private fun <T : Comparable<in T>> partition(array: Array<T>, lowIdx: Int, highIdx: Int): Int {
            val pivot = array[highIdx]
            var i = lowIdx

            for (j in i until highIdx) {
                if (array[j] <= pivot) {
                    swap(array, i, j)
                    i++
                }
            }
            swap(array, highIdx, i)
            return i
        }

        private fun <T> swap(array: Array<T>, i: Int, j: Int) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }
    }
}


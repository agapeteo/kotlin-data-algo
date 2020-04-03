package sort

object ListBasedCountingSort {

    fun sort(array: IntArray) {
        val countingList = arrayOfNulls<MutableList<Int>>(max(array) + 1)
        for (intValue in array) {
            var listByIdx = countingList[intValue]
            if (listByIdx == null) {
                listByIdx = mutableListOf(intValue)
                countingList[intValue] = listByIdx
            } else {
                listByIdx.add(intValue)
            }
        }
        var i = 0
        for (eachList in countingList) {
            if (eachList == null) continue

            for (eachValue in eachList) {
                array[i] = eachValue
                i++
            }
        }
    }

    private fun max(array: IntArray): Int {
        var max = Int.MIN_VALUE
        for (intValue in array) {
            if (intValue > max) {
                max = intValue
            }
        }
        return max
    }
}
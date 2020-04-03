package sort

object CountingSort {
    fun sort(array: IntArray): IntArray {
        val max = max(array)
        val countArr = IntArray(max + 1)
        for (i in array) {
            countArr[i]++
        }
        var runningSum = 0
        for (i in countArr.indices) {
            runningSum += countArr[i]
            countArr[i] = runningSum
        }

        val result = IntArray(array.size)
        for (i in array.size - 1 downTo 0) {
            val curValue = array[i]
            val curCount = countArr[curValue]
            result[curCount - 1] = curValue
            countArr[curValue]--
        }
        return result
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
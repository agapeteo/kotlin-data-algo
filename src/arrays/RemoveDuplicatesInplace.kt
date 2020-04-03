package arrays

object InPlaceDuplicateRemoval {
    fun <T> remove(arr: Array<T>): Int {
        arr.sort()
        var i = 0
        for (j in 1 until arr.size) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j]
                i++
            }
        }
        return i
    }
}

package list

class FindInRotatedSortedList<T : Comparable<T>>(val list: List<T>){
    private val rotationIndex = findRotationIdx(list)

    fun findIdx(obj: T): Int{
        val valueAtRotationPoint = list[rotationIndex]

        if (obj >= valueAtRotationPoint && obj <= list.last()) {
            return list.binarySearch(obj, rotationIndex, list.lastIndex + 1)
        }
        return list.binarySearch(obj, 0, rotationIndex)
    }

    fun findRotationIdx(list: List<T>): Int {
        if (list.first() < list.last()) return 0

        val midIdx = list.lastIndex / 2
        return findRotationIdx(list, 0, midIdx / 2, (list.lastIndex + midIdx) / 2, list.lastIndex)
    }

    private fun findRotationIdx(list: List<T>, left: Int, midLeft: Int, midRight: Int, right: Int): Int {
        if (midLeft == midRight) return midLeft + 1

        if (list[midLeft] < list.first()) {
            val mid = (left + midLeft) / 2
            return findRotationIdx(list, left, (left + mid) / 2, (midLeft + mid / 2), midLeft)
        }

        if (list[midRight] > list.last()) {
            val mid = (midRight + right) / 2
            return findRotationIdx(list, midRight, (midRight + mid) / 2, (mid + right) / 2, right)
        }

        val mid = (midLeft + midRight) / 2
        return findRotationIdx(list, midLeft, (midLeft + mid) / 2, (mid + midRight) / 2, midRight)
    }
}

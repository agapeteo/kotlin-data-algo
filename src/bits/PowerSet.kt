package bits

object PowerSet {

    fun <T> powerSet(inputSet: List<T>): List<List<T>> {

        fun binaryToSet(number: Int): List<T> {
            val curSet = mutableListOf<T>()
            var i = 0
            var curNumber = number
            while (curNumber > 0) {
                if ((curNumber and 1) != 0) {
                    curSet.add(inputSet[i])
                }
                curNumber = curNumber shr 1
                i++
            }
            return curSet
        }

        val powerSet = mutableListOf<List<T>>()
        val max = 1 shl inputSet.size

        for (i in 0 until max) {
            powerSet.add(binaryToSet(i))
        }
        return powerSet
    }
}
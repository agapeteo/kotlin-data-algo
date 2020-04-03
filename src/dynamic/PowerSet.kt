package dynamic

object PowerSet {

    fun <T> powerSet(inputSet: List<T>): List<List<T>> {
        val powerSet = mutableListOf<List<T>>()

        for (item in inputSet) {
            val powerSetIter = powerSet.listIterator()

            while (powerSetIter.hasNext()) {
                val curSet = powerSetIter.next()
                val newSet = curSet.plus(item)
                powerSetIter.add(newSet)
            }
            powerSet.add(listOf(item))
        }
        powerSet.add(emptyList())

        return powerSet
    }
}
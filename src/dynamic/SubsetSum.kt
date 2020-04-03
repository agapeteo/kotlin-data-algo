import visual.*


class SubsetSum(val visual: VisualFunction = BasicVisualFunction()) {

    fun isSubsetSum(ints: IntArray, idx: Int, sum: Int, otherNotes: String = ""): Boolean {
        val value = if (idx >= ints.size) -1 else ints[idx]
        visual.enter("${object {}.javaClass.enclosingMethod.name}", "idx $idx($value), sum $sum  $otherNotes")

        if (sum == 0) {
            visual.exit("true")
            return true
        }
        if (idx == 0) {
            visual.exit("false")
            return false
        }

        // If last element is greater than
        // sum, then ignore it
        return if (ints[idx - 1] > sum)
            isSubsetSum(ints, idx - 1, sum)

        /* else, check if sum can be obtained
      by any of the following
          (a) including the last element
          (b) excluding the last element */
        else
            isSubsetSum(ints, idx - 1, sum, "a")
                    ||
                    isSubsetSum(ints, idx - 1, sum - ints[idx - 1], "-> $sum - ${ints[idx - 1]}")
    }

}
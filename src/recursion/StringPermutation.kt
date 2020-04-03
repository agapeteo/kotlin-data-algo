package recursion

object StringPermutation {

    fun permute(str: String, prefix: String = "", curPermutations: MutableList<String> = mutableListOf()): List<String> {
        if (str.isNotEmpty()) {
            for (charIdx in str.indices) {
                val newPrefix = "${prefix}${str[charIdx]}"
                val strBeforeCurChar = str.substring(0, charIdx)
                val isLastIdx = charIdx == str.length - 1
                val strAfterCurChar = if (isLastIdx) "" else str.substring(charIdx + 1)
                val newStr = "${strBeforeCurChar}${strAfterCurChar}"

                permute(newStr, newPrefix, curPermutations)
            }
        } else {
            curPermutations.add(prefix)
        }
        return curPermutations
    }
}
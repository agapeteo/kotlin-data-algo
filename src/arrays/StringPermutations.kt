package arrays

class StringPermutations {

    companion object {
        fun printPermutations(prefix: String = "", str: String) {

            if (str.isBlank()) {
                println(prefix)
                return
            }

            for (i in 0 until str.length) {
                val newPrefix = prefix + str.toCharArray()[i]
                val rem = str.substring(0, i) + str.substring(i + 1)

                printPermutations(newPrefix, rem)

                println("printPermutations($newPrefix, $rem)")

                print("exit of -> prefix: $prefix, str: $str")
            }
        }
    }

}
package arrays

class SingleParenthesesValidator(val open: Char, val closed: Char) {

    fun validate(str: String): Boolean {
        var counter = 0
        if (str.isBlank()) return false;

        for (i in 0 until str.length) {
            val char = str[i]
            if (char == open) {
                counter++
            } else if (char == closed) {
                if (counter == 0) return false
                counter--
            }
        }
        return counter == 0
    }
}
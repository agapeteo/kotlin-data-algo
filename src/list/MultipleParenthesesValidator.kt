package list

import java.util.*

class MultipleParenthesesValidator(val openArr: Array<Char>, val closeArr: Array<Char>) {

    fun validate(str: String): Boolean {
        if (str.isBlank()) return false;

        val closeChars = mapFor(closeArr)
        val openChars = mapFor(openArr)
        val stack: Deque<Char> = LinkedList()

        for (i in 0 until str.length) {
            val curChar = str[i]
            if (openChars.contains(curChar)) {
                stack.push(curChar)
            } else if (closeChars.contains(curChar)) {
                if (stack.isEmpty()) return false

                val topChar = stack.pop()
                if (closeChars[curChar] != openChars[topChar]) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

    private fun mapFor(chars: Array<Char>): Map<Char, Int> {
        val result = hashMapOf<Char, Int>()
        for ((idx, c) in chars.withIndex()) {
            result[c] = idx
        }

        return result
    }
}
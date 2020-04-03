package list

class ValidateParentheses {
    companion object {
        fun validate(str: String): Boolean {
            val stack: Stack<Char> = DefaultLinkedList()

            for (i in 0 until str.length) {
                val char = str[i]

                if (char == '(' || char == '{') {
                    stack.push(str[i])
                } else if (char == ')')  {
                    val c = stack.pop()
                    if (c != '(') return false
                }
                else if (char == '}')  {
                    val c = stack.pop()
                    if (c != '{') return false
                } else {
                    return false // not valid char
                }
            }
            return stack.size() == 0
        }
    }
}

fun main() {
    println(ValidateParentheses.validate("({()})()"))
    println(ValidateParentheses.validate("({()}})"))

}

import visual.*

class ParanthessisGenerator(val visual: VisualFunction = BasicVisualFunction()) {

    fun generateParens(count: Int): List<String> {
        visual.enter("generateParams")
        val chars = arrayOfNulls<Char>(count * 2)
        val result = mutableListOf<String>()
        addParen(result, count, count, chars, 0)
        return result
        visual.exit("root")
    }

    private fun addParen(list: MutableList<String>, leftRem: Int, rightRem: Int, chars: Array<Char?>, count: Int, otherNotes: String = "") {
        visual.enter("generateParams", "leftRem $leftRem, rightRem $rightRem count $count -> $otherNotes")

        if (leftRem < 0 || rightRem < leftRem) {
            visual.exit("leftRem $leftRem, rightRem $rightRem count $count")
            return
        } // invalid state

        if (leftRem == 0 && rightRem == 0) { // no more parens left
            list.add(chars.joinToString(""))
        } else {
            if (leftRem > 0) {
                chars[count] = '('
                addParen(list, leftRem - 1, rightRem, chars, count + 1, "(")
            }
            if (rightRem > leftRem) {
                chars[count] = ')'
                addParen(list, leftRem, rightRem - 1, chars, count + 1, ")")
            }
        }
    }
}
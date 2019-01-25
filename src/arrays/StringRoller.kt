package arrays

class StringRoller(private val inputString: String) {

    enum class Direction { Left, Right }

    fun rotate(rotationCount: Int = 1, direction: Direction): String {
        return when (direction) {
            Direction.Left -> rotateLeft(rotationCount)
            Direction.Right -> rotateRight(rotationCount)
        }
    }

    private fun rotateRight(rotationCount: Int): String {
        val chars = inputString.toCharArray()
        repeat(rotationCount) {
            val last = chars[chars.size - 1]
            for (i in chars.size - 1 downTo 1) {
                chars[i] = chars[i - 1]
            }
            chars[0] = last
        }
        return String(chars)
    }

    private fun rotateLeft(rotationCount: Int): String {
        val chars = inputString.toCharArray()
        repeat(rotationCount) {
            val first = chars[0]
            for (i in 0 until chars.size - 1) {
                chars[i] = chars[i + 1]
            }
            chars[chars.size - 1] = first
        }
        return String(chars)
    }
}
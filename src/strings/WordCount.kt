package strings

object WordCount {
    fun wordCount(text: String): Map<String, Int> {
        return text.split(" ").groupingBy { it }.eachCount()
    }
}
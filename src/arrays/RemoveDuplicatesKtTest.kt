package arrays

import org.junit.jupiter.api.Test

internal class RemoveDuplicatesKtTest {

    @Test
    fun removeDuplicates() {
        val a = arrayOf(1, 2, 1, 3, 3, 3, 4, 5, 5, 6)
        val actual = remove(a)
        println(actual.toList())
    }
}
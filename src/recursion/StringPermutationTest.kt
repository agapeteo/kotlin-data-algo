package recursion

import org.junit.jupiter.api.Test

internal class StringPermutationTest {

    @Test
    fun permute() {
        val actual = StringPermutation.permute("abcd")
        println(actual)
    }
}
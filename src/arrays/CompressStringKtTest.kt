package arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompressStringKtTest {

    @Test
    fun compressString() {

        println(arrays.compressString("aaaab"))
        println(arrays.compressString("abcd"))
        println(arrays.compressString("abcdd"))
        println(arrays.compressString("abbbccddd"))
        println(arrays.compressString("aabbccaa"))
    }
}
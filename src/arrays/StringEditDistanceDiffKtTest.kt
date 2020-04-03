package arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StringEditDistanceDiffKtTest {

    @Test
    fun isEditDistanceGreaterThan1() {
        println(arrays.isEditDistanceGreaterThan1("abc", "abc12"))
        println(arrays.isEditDistanceGreaterThan1("12abc", "abc"))
        println(arrays.isEditDistanceGreaterThan1("123abc", "abc"))
        println(arrays.isEditDistanceGreaterThan1("abc", "abc123"))

        println(arrays.isEditDistanceGreaterThan1("abc", "abc"))
        println(arrays.isEditDistanceGreaterThan1("1abc", "abc"))
        println(arrays.isEditDistanceGreaterThan1("abc", "abc1"))
    }
}
package arrays

import org.junit.jupiter.api.Test

internal class InPlaceDuplicateRemovalTest{
    @Test
    fun inPlaceRemoval(){
        val arr = arrayOf("a", "b", "a", "c", "a")
        val actual = InPlaceDuplicateRemoval.remove(arr)
        println(actual)
        println(arr.contentToString())
    }
}
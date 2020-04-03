package arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReplaceSpacesKtTest {

    @Test
    fun replaceSpaces() {
        // given
        val string = "this is my string"
        val charArray = arrayOfNulls<Char?>(string.length + 3 * 3 - 3)
        for (i in 0 until string.length){
            charArray[i] = string[i]
        }

        // when
        arrays.replaceSpaces(charArray, string.length)
        val actual = StringBuilder()
        charArray.forEach { actual.append(it) }

        // then
        assertEquals("this%20is%20my%20string", actual.toString() )
    }
}
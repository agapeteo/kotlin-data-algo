package arrays

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringRollerTest {

    @Test
    fun `rotate right, steps 1`() {
        // given
        val given = "ABCD"

        // when
        val actual = StringRoller(given).rotate(direction = StringRoller.Direction.Right)

        // then
        assertEquals("DABC", actual)
    }

    @Test
    fun `rotate left, steps 1`() {
        // given
        val given = "ABCD"

        // when
        val actual = StringRoller(given).rotate(direction = StringRoller.Direction.Left)

        // then
        assertEquals("BCDA", actual)
    }

    @Test
    fun `rotate right, steps 2`() {
        // given
        val given = "ABCD"

        // when
        val actual = StringRoller(given).rotate(2, StringRoller.Direction.Right)

        // then
        assertEquals("CDAB", actual)
    }

    @Test
    fun `rotate left, steps 2`() {
        // given
        val given = "ABCD"

        // when
        val actual = StringRoller(given).rotate(2, StringRoller.Direction.Left)

        // then
        assertEquals("CDAB", actual)
    }

    @Test
    fun `rotate left, steps - string length`() {
        // given
        val given = "ABCD"

        // when
        val actual = StringRoller(given).rotate(given.length, StringRoller.Direction.Left)

        // then
        assertEquals("ABCD", actual)
    }
}
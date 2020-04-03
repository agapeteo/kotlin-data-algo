package arrays

import arrays.KadanesMaxSubArraySum.Result
import org.junit.jupiter.api.Test
import java.util.concurrent.ExecutorService
import kotlin.test.assertEquals

internal class KadanesMaxSubArraySumTest {

    @Test
    fun maxSum() {
        // given
        val list = listOf(34, -50, 42, 14, -5, 86)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(137, 2, 6), actual)
    }

    @Test
    fun maxSum_two_options() {
        // given
        val list = listOf(34, 1, -50, 42, 14, -5, 86)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(137, 3, 7), actual)
    }

    @Test
    fun maxSum_all_negative() {
        // given
        val list = listOf(-34, -50, -42, -14, -5)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(0, actual.maxSum)
    }

    @Test
    fun maxSum_all_negative_except_first() {
        // given
        val list = listOf(34, -50, -42, -14, -5)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(34, 0, 1), actual)
    }

    @Test
    fun maxSum_all_negative_except_first_and_second() {
        // given
        val list = listOf(34, 50, -42, -14, -5)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(84, 0, 2), actual)
    }

    @Test
    fun maxSum_all_negative_except_second_and_third() {

        // given
        val list = listOf(-2, 1, 50, -42, -14, -5)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(51, 2, 3), actual)
    }

    @Test
    fun maxSum_all_negative_except_last() {
        // given
        val list = listOf(-2, -1, -50, -42, -14, 5)

        // when
        val actual = KadanesMaxSubArraySum.maxSum(list)

        // then
        assertEquals(Result(5, 5, 6), actual)

    }
    
}
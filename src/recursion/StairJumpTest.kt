package recursion

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StairJumpTest {

    @Test
    fun waysCount() {
        print(StairJump.waysCount(5, intArrayOf(1, 2, 5)))
    }
}
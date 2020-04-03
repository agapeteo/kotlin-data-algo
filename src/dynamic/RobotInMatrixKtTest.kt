package dynamic

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RobotInMatrixKtTest {

    @Test
    fun `no path`() {
        // given
        val matrix = Array2D<Boolean>(3, 3)
        matrix[0, 1] = false
        matrix[1, 0] = false

        // when
        val actual = getPath(matrix)

        // then
        assertEquals(listOf<Point>(), actual)
    }

    @Test
    fun `with path`() {
        // given
        val matrix = Array2D<Boolean>(3, 3)
        matrix[1, 0] = false
        matrix[1, 2] = false

        // when
        val actual = getPath(matrix)

        // then
        assertEquals(listOf(
                Point(0,0), Point(0, 1),
                Point(1,1),
                Point(2, 1), Point(2,2)),
                actual)
    }

//    @Test
    fun `with path, just for fun ?????`() {
        // given
        val matrix = Array2D<Boolean>(4, 4)
        matrix[1, 0] = false
        matrix[1, 2] = false

        // when
        val actual = getPath(matrix)

        // then
        assertEquals(listOf(
                Point(0,0), Point(0, 1),
                Point(1,1),
                Point(2, 1), Point(2,2)),
                actual)
    }
}
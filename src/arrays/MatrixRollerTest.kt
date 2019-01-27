package arrays

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MatrixRollerTest {

    @Test
    fun `rotate right`() {
        // given
        val given = buildMatrix()
        val expected = expectedRotatedRight()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Right, count = 1)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(expected[i][j], roller.matrix[i][j])
            }
        }
    }

    @Test
    fun `rotate right 4 times`() {
        // given
        val given = buildMatrix()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Right, count = 4)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(buildMatrix()[i][j], roller.matrix[i][j])
            }
        }
    }

    @Test
    fun `rotate left 4 times`() {
        // given
        val given = buildMatrix()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Left, count = 4)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(buildMatrix()[i][j], roller.matrix[i][j])
            }
        }
    }

    @Test
    fun `rotate left and than right`() {
        // given
        val given = buildMatrix()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Left, count = 1)
        roller.rotate(MatrixRoller.Direction.Right, count = 1)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(buildMatrix()[i][j], roller.matrix[i][j])
            }
        }
    }

    @Test
    fun `rotate right 2 times and then 1 time left`() {
        // given
        val given = buildMatrix()
        val expected = expectedRotatedRight()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Right, count = 2)
        roller.rotate(MatrixRoller.Direction.Left, count = 1)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(expected[i][j], roller.matrix[i][j])
            }
        }
    }

    @Test
    fun `rotate left`() {
        // given
        val given = buildMatrix()
        val expected = expectedRotatedLeft()

        // when
        val roller = MatrixRoller(given)
        roller.rotate(MatrixRoller.Direction.Left, count = 1)

        // then
        for (i in 0 until given.size) {
            for (j in 0 until given.size) {
                assertEquals(expected[i][j], roller.matrix[i][j])
            }
        }
    }

    private fun buildMatrix(): Array<IntArray> {
        val row1 = intArrayOf(1, 2, 3, 4, 5)
        val row2 = intArrayOf(6, 7, 8, 9, 10)
        val row3 = intArrayOf(11, 12, 13, 14, 15)
        val row4 = intArrayOf(16, 17, 18, 19, 20)
        val row5 = intArrayOf(21, 22, 23, 24, 25)
        return arrayOf(row1, row2, row3, row4, row5)
    }

    private fun expectedRotatedRight(): Array<IntArray> {
        val row1 = intArrayOf(21, 16, 11, 6, 1)
        val row2 = intArrayOf(22, 17, 12, 7, 2)
        val row3 = intArrayOf(23, 18, 13, 8, 3)
        val row4 = intArrayOf(24, 19, 14, 9, 4)
        val row5 = intArrayOf(25, 20, 15, 10, 5)
        return arrayOf(row1, row2, row3, row4, row5)
    }

    private fun expectedRotatedLeft(): Array<IntArray> {
        val row1 = intArrayOf(5, 10, 15, 20, 25)
        val row2 = intArrayOf(4, 9, 14, 19, 24)
        val row3 = intArrayOf(3, 8, 13, 18, 23)
        val row4 = intArrayOf(2, 7, 12, 17, 22)
        val row5 = intArrayOf(1, 6, 11, 16, 21)
        return arrayOf(row1, row2, row3, row4, row5)
    }
}
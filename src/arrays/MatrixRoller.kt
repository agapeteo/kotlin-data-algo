package arrays

import java.util.*

class MatrixRoller(val matrix: Array<IntArray>, private val verbose: Boolean = false) {

    enum class Direction { Left, Right }

    data class Coordinate(val rowIdx: Int, val columnIdx: Int)

    private val noCoordinate = Coordinate(-1, -1)

    fun rotate(direction: Direction, count: Int) {
        repeat(count) { rotate(direction) }
    }

    private fun rotate(direction: Direction): Array<IntArray> {
        for (layer in 0 until matrix.size / 2) {

            val lastIdx = matrix.size - 1 - layer

            for (i in layer until lastIdx) {
                if (verbose) println("\n-- i: $i --\n")

                val offset = i - layer

                val top = Coordinate(layer, i)
                val left = Coordinate(lastIdx - offset, layer)
                val bottom = Coordinate(lastIdx, lastIdx - offset)
                val right = Coordinate(i, lastIdx)

                val tmpTopValue = matrix[layer][i]
                if (verbose) {
                    println("tmpTopValue<-[$layer][$i]($tmpTopValue)\n")
                }

                when (direction) {

                    Direction.Right -> {
                        matrix[top.rowIdx][top.columnIdx] = matrix[left.rowIdx][left.columnIdx]
                        if (verbose) println("Left->Top:").also { printMatrixMovement(from = left, to = top) }

                        matrix[left.rowIdx][left.columnIdx] = matrix[bottom.rowIdx][bottom.columnIdx]
                        if (verbose) println("Bottom->Left:").also { printMatrixMovement(from = bottom, to = left) }

                        matrix[bottom.rowIdx][bottom.columnIdx] = matrix[right.rowIdx][right.columnIdx]
                        if (verbose) println("Right->Bottom:").also { printMatrixMovement(from = right, to = bottom) }

                        matrix[right.rowIdx][right.columnIdx] = tmpTopValue
                        if (verbose) println("Top->Right:").also { printMatrixMovement(from = noCoordinate, to = right) }
                                .also { println("\n--- layer: $layer completed. \n") }
                    }

                    Direction.Left -> {
                        matrix[top.rowIdx][top.columnIdx] = matrix[right.rowIdx][right.columnIdx]
                        if (verbose) println("Right->Top:").also { printMatrixMovement(from = right, to = top) }

                        matrix[right.rowIdx][right.columnIdx] = matrix[bottom.rowIdx][bottom.columnIdx]
                        if (verbose) println("Bottom->Right:").also { printMatrixMovement(from = bottom, to = right) }

                        matrix[bottom.rowIdx][bottom.columnIdx] = matrix[left.rowIdx][left.columnIdx]
                        if (verbose) println("Left->Bottom:").also { printMatrixMovement(from = left, to = bottom) }

                        matrix[left.rowIdx][left.columnIdx] = tmpTopValue
                        if (verbose) println("Top->Left:").also { printMatrixMovement(from = noCoordinate, to = left) }
                                .also { println("\n--- layer: $layer completed. \n") }
                    }
                }
            }
        }
        return matrix
    }

    private fun printMatrixMovement(from: Coordinate, to: Coordinate) {
        val matchesFrom = { c: Coordinate -> from.rowIdx == c.rowIdx && from.columnIdx == c.columnIdx }
        val matchesTo = { c: Coordinate -> to.rowIdx == c.rowIdx && to.columnIdx == c.columnIdx }

        matrix.forEachIndexed { rowIdx, row ->
            row.forEachIndexed { columnIdx, _ ->
                val coordinate = Coordinate(rowIdx, columnIdx)
                val value = matrix[rowIdx][columnIdx]

                val formattedValue = when {
                    matchesFrom(coordinate) -> " $value> "
                    matchesTo(coordinate) -> " >$value "
                    else -> " $value "
                }
                print(formattedValue)
            }
            println()
        }
        println()
    }

    fun printMatrix() {
        matrix.forEach { println(Arrays.toString(it)) }
    }
}


package dynamic

data class Point(val row: Int, val column: Int)

fun getPath(matrix: Array2D<Boolean?>): List<Point> {
    val list = mutableListOf<Point>()
    val cache = mutableMapOf<Point, Boolean>()

    if (findPath(matrix, matrix.rowsCount - 1, matrix.columnsCount - 1, cache, list)) {
        return list
    }
    return emptyList()
}

private fun findPath(matrix: Array2D<Boolean?>, row: Int, column: Int, cache: MutableMap<Point, Boolean>, points: MutableList<Point>): Boolean {
    if (row < 0 || column < 0 ||
            (matrix[row, column] != null && !matrix[row, column]!!) ) {
        return false
    }

    val point = Point(row, column)

    if (cache.containsKey(point)) {
        return cache.getValue(point)
    }

    var hasPath = false

    val isStartPoint = row == 0 && column == 0

    if (isStartPoint ||
            findPath(matrix, row - 1, column, cache, points) ||
            findPath(matrix, row, column - 1, cache, points)) {

        points.add(point)
        hasPath = true
    }

    cache[point] = hasPath

    return hasPath
}


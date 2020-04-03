package dynamic

fun productOf(a: Int, b: Int): Int {
    val bigger = if (a > b) a else b
    val smaller = if (a < b) a else b

    val cache = arrayOfNulls<Int>(smaller + 1)
    return productOf(smaller, bigger, cache)
}

private fun productOf(smaller: Int, bigger: Int, cache: Array<Int?>): Int {
    if (smaller == 0) return 0
    if (smaller == 1) return bigger
    if (cache[smaller] != null) return cache[smaller]!!

    // compute half, if even - double it, otherwise compute other half
    val smallerHalf = smaller shr 1 // divide by 2
    val side1 = productOf(smallerHalf, bigger, cache)
    val side2 =
            if (smaller % 2 == 0) {
                side1
            } else {
                productOf(smaller - smallerHalf, bigger, cache)
            }

    cache[smaller] = side1 + side2
    return cache[smaller]!!
}
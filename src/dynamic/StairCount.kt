package dynamic

fun stairCount(n: Int, count: Int = 0): Int {
    if (n < 0) return 0
    if (n == 0) return 1

    return stairCount(n - 1, count + 1) + stairCount(n - 2, count + 1)
}
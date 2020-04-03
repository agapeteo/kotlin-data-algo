package arrays

fun remove(a: Array<Int>): Array<Int?> {
    a.sort()

    var i = 0
    var j = i + 1

    while (j < a.size) {
        if (a[j] != a[i]) {
            a[++i] = a[j]
        }
        j++
    }

    return a.copyOf(i + 1)
}
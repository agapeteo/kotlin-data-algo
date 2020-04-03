package arrays

import java.io.File
import java.util.*


fun main() {

    printDirContent(File("/Users/emix/go/src/practicalalgo"))

}

fun printDirContent(dir: File, tabsCount: Int = 0, ignoreHidden: Boolean = true) {
    require(dir.exists()) { "$dir must exist" }
    require(dir.isDirectory) { "$dir must be directory" }

    val tabs = StringBuilder()
    repeat(tabsCount) { tabs.append("\t") }

    val dirOutput = StringBuilder()
    dirOutput.append(tabs).append(dir.name).append("/")

    println(dirOutput.toString())

    for (file in dir.listFiles()) {
        if (ignoreHidden && file.name.startsWith(".")) continue

        if (file.isDirectory) {
            printDirContent(file, tabsCount + 1, ignoreHidden)
        } else {
            val fileOutput = StringBuilder()
            fileOutput.append("\t").append(tabs).append(file.name)

            println(fileOutput.toString())
        }
    }
}

fun <T> binarySearch(list: List<Comparable<in T>>, value: T): Int {
    var lowIdx = 0
    var highIdx = list.size - 1

    while (lowIdx <= highIdx) {
        val midIdx = lowIdx + (highIdx - lowIdx) / 2
        when {
            list[midIdx] == value -> return midIdx
            list[midIdx] < value -> lowIdx = midIdx + 1
            list[midIdx] > value -> highIdx = midIdx - 1
        }
    }
    return -(lowIdx + 1)
}

fun <T> binarySearchRecursive(list: List<Comparable<in T>>, value: T, lowIdx: Int = 0, highIdx: Int = list.size - 1): Int {
    val notFound = -(lowIdx + 1)
    if (lowIdx > highIdx) {
        return notFound
    }
    val midIdx = lowIdx + (highIdx - lowIdx) / 2
    return when {
        list[midIdx] == value -> midIdx
        list[midIdx] < value -> binarySearchRecursive(list, value, midIdx + 1, highIdx)
        list[midIdx] > value -> binarySearchRecursive(list, value, lowIdx, midIdx - 1)
        else -> notFound
    }
}

fun <T> binarySearchLowestIndex(list: List<Comparable<in T>>, value: T): Int {
    var lowIdx = -1
    var highIdx = list.size
    while (lowIdx + 1 < highIdx) {
        val midIdx = (lowIdx + highIdx) ushr 1 // shifting but to right is same as dividing by 2
        if (list[midIdx] >= value) {
            highIdx = midIdx
        } else {
            lowIdx = midIdx
        }
    }
    return when (value) {
        list[highIdx] -> highIdx
        else -> -(highIdx + 1)
    }
}

fun average(numbers: List<Int>): Int {
    var sum = 0
    for (n in numbers) {
        sum += n
    }
    return sum / numbers.size
}

fun max(numbers: List<Int>): Int {
    var max = Int.MIN_VALUE
    for (n in numbers) {
        if (n > max) {
            max = n
        }
    }
    return max
}

fun idxOf(value: Int, list: List<Int>): Int {

    for ((idx, element) in list.withIndex()) {
        if (element == value) return idx
    }
    return -1
}
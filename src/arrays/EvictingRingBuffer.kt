package arrays

class EvictingRingBuffer<T>(val maxSize: Int) {
    private val container: Array<T> = arrayOfNulls<Any?>(maxSize) as Array<T>
    private var elementsCount = 0
    private var writeIdx = 0
    private var readIdx = 0

    fun enqueue(element: T) {
        container[writeIdx] = element
        writeIdx = incrementIdx(writeIdx)
        if (elementsCount == maxSize) {
            readIdx = writeIdx
        } else {
            elementsCount++
        }
    }

    fun dequeue(): T {
        require(elementsCount > 0) { "buffer is empty" }

        val element = container[readIdx]
        elementsCount--
        readIdx = incrementIdx(readIdx)

        return element
    }

    fun elements(): Array<T> {
        val result: Array<T> = arrayOfNulls<Any?>(elementsCount) as Array<T>
        var idx = readIdx
        for (i in 0 until elementsCount) {
            result[i] = container[idx]
            idx = incrementIdx(idx)
        }
        return result
    }

    private fun incrementIdx(idx: Int): Int {
        return (idx + 1) % maxSize
    }
}
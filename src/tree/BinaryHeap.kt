package tree

class BinaryHeap<E : Comparable<E>> : Heap<E> {

    private val elements = mutableListOf<E>()

    override fun size(): Int {
        return elements.size
    }

    override fun peek(): E {
        assert (elements.isNotEmpty() ) { "heap is empty" }
        return elements[0]
    }

    override fun pop(): E {
        assert (elements.isNotEmpty() ) { "heap is empty" }

        if (elements.size == 1){
            return elements.removeAt(0)
        }

        val result = elements[0]
        val latest = elements.removeAt(elements.size - 1)
        elements[0] = latest

        siftDown(0)

        return result
    }

    private fun siftDown(idx: Int) {
        if (idx < 0 || idx >= elements.size/2) return

        val leftIdx = leftChildIdx(idx)
        val rightIdx = rightChildIdx(idx)

        val largerChildIdx = if (rightIdx < elements.size && elements[rightIdx] > elements[leftIdx]) {
            rightIdx
        } else {
            leftIdx
        }

        if (elements[largerChildIdx] > elements[idx]){
            swap(idx, largerChildIdx)
            siftDown(largerChildIdx)
        }
    }

    override fun push(value: E) {
        elements.add(value)

        siftUp(elements.size - 1)
    }

    private fun siftUp(idx: Int) {
        if (idx <= 0) return

        val parentIdx = parentIdx(idx)

        if (elements[idx] > elements[parentIdx]){
            swap(idx, parentIdx)
            siftUp(parentIdx)
        }
    }

    override fun elements(): List<E> {
        val result = mutableListOf<E>()

        result.addAll(elements)

        return result
    }

    private fun swap(idxI: Int, idxJ: Int){
        val tmp: E = elements[idxI]
        elements[idxI] = elements[idxJ]
        elements[idxJ] = tmp
    }

    private fun leftChildIdx(idx: Int): Int = idx * 2 + 1
    private fun rightChildIdx(idx: Int): Int = idx * 2 + 2
    private fun parentIdx(idx: Int): Int = (idx - 1) / 2
}
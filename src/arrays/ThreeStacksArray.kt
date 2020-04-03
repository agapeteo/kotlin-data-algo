package arrays

import list.Stack


class ThreeStacksArray<E>(initSize: Int = 30) {
    internal var array = arrayOfNulls<Any>(initSize)

    val stackA = StackMember(0, 9, -1)
    val stackB = StackMember(10, 19, 9)
    val stackC = StackMember(20, 29, 19)

    @Suppress("UNCHECKED_CAST")
    inner class StackMember(internal var startIdx: Int, internal var endIdx: Int, private var topIdx: Int) : Stack<E> {

        override fun peek(): E {
            assert(topIdx >= startIdx) { "stack is empty" }

            return array[topIdx] as E
        }

        override fun pop(): E {
            assert(topIdx >= startIdx) { "stack is empty" }

            val result = array[topIdx]
            array[topIdx] = null
            topIdx--

            return result as E
        }

        override fun push(element: E) {
            topIdx++
            if (topIdx > endIdx) {
                resize(this)
            }
            array[topIdx] = element
        }

        override fun size(): Int {
            return array.size
        }

        fun moveIdx(increment: Int) {
            startIdx += increment
            endIdx += increment
            topIdx += increment
        }
    }

    private fun resize(member: StackMember) {
        val oldMemberSize = member.endIdx - member.startIdx + 1
        val increment = oldMemberSize * 2
        val newArraySize = array.size + increment

        when (member) {
            stackA -> {
                val newArray = arrayOfNulls<Any>(newArraySize)

                System.arraycopy(array, 0, newArray, 0, member.endIdx + 1)
                System.arraycopy(array, stackB.startIdx, newArray, stackB.startIdx + increment, array.size - stackB.startIdx)

                stackB.moveIdx(increment)
                stackC.moveIdx(increment)

                array = newArray
            }
            stackB -> {
                val newArray = arrayOfNulls<Any>(newArraySize)

                System.arraycopy(array, 0, newArray, 0, member.endIdx - member.startIdx + 1)
                System.arraycopy(array, 0, newArray, 0, member.endIdx + 1)
                System.arraycopy(array, stackC.startIdx, newArray, stackC.startIdx + increment, array.size - stackC.startIdx)

                stackC.moveIdx(increment)

                array = newArray
            }
            stackC -> {
                array = array.copyOf(newArraySize)
            }
        }
        member.endIdx += increment
    }
}
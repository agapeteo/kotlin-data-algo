package list

import kotlin.math.pow

fun sumLists(firstList: DefaultLinkedList<Int>, secondList: DefaultLinkedList<Int>): LinkedList<Int> {
    val sum = firstList.listToInt() + secondList.listToInt()
    return intToList(sum)
}

fun DefaultLinkedList<Int>.listToInt(): Int {
    var sum = 0

    var i = 0

    var curNode = head

    while (curNode != null) {
        val curNumber: Int = if (i == 0) {
            curNode.value
        } else {
            curNode.value * 10.toDouble().pow(i).toInt()
        }

        sum += curNumber
        i++
        curNode = curNode.next
    }

    return sum
}

fun intToList(number: Int): LinkedList<Int> {
    val result = DefaultLinkedList<Int>()

    var num = number

    while (num != 0){
        result.append(num % 10)
        num /= 10
    }

    return result
}
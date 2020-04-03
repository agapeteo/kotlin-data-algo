package list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListNodeKtTest {

    @Test
    fun `add elements and list`() {
        // given
        val node = ListNode(0)

        // when
        node.append(1)
        node.append(2)
        node.append(3)

        // then
        assertEquals(listOf(0, 1, 2, 3), node.elements())
    }

    @Test
    fun `remove at idx 3`() {
        // given
        val node = ListNode(0)
        node.append(1)
        node.append(2)
        node.append(3)
        node.append(4)
        node.append(5)

        // when
        node.removeAt(3)

        // then
        assertEquals(listOf(0, 1, 2, 4, 5), node.elements())
    }

    @Test
    fun `remove at last idx`() {
        // given
        val node = ListNode(0)
        node.append(1)
        node.append(2)
        node.append(3)
        node.append(4)
        node.append(5)

        // when
        node.removeAt(5)

        // then
        assertEquals(listOf(0, 1, 2, 3, 4), node.elements())
    }
}
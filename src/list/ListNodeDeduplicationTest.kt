package list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ListNodeDeduplicationTest {

    @Test
    fun deduplicate() {
        // given
        val node = ListNode("a")
        node.append("b")
        node.append("b")
        node.append("a")
        node.append("a")
        node.append("a")
        node.append("c")

        // when
        node.deduplicate()

        // then
        assertEquals(listOf("a", "b", "c"), node.elements())
    }
}
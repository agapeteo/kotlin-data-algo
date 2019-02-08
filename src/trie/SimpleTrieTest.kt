package trie

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SimpleTrieTest {

    @Test
    fun `add and find`() {
        // given
        val words = listOf("apple", "appreciate", "accurate", "cat", "cute", "umbrella")

        // when
        val trie = SimpleTrie().apply {
            words.forEach { add(it) }
        }

        // then
        words.forEach { if (!trie.contains(it)) fail<Any>("expected to contain '$it' ") }

        listOf("apology", "dat", "cutes", "dude", "umy").forEach { if (trie.contains(it)) fail<Any>("expected not to contain '$it' ") }
    }
}
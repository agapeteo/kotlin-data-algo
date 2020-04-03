

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ParensKtTest {
    val verbose = false

    @Test
    fun `three`() {
        // given // when
        val generator = ParanthessisGenerator()
        val actual = generator.generateParens(3)

        // then
        if (verbose) actual.forEach { println(it) }
        val expected = listOf("((()))", "(()())", "(())()", "()(())", "()()()")
        assertEquals(expected, actual)
        println(generator.visual.traceCalls)
        println(generator.visual.buildTextSequence())
    }

    @Test
    fun `two`() {
        // given // when
        val generator = ParanthessisGenerator()
        val actual = generator.generateParens(2)

        // then
        if (verbose) actual.forEach { println(it) }
        val expected = listOf("(())", "()()")
        assertEquals(expected, actual)

    }
}
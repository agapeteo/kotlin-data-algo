package arrays

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ThreeStacksArrayTest {

    @Test
    fun `fill each before resize`() {
        // given
        val stacks = ThreeStacksArray<String>()

        // when
        stacks.stackA.push("A1")
        stacks.stackB.push("B1")
        stacks.stackB.push("B2")
        stacks.stackC.push("C1")
        stacks.stackC.push("C2")
        stacks.stackC.push("C3")

        val actual = mutableListOf<String>()
        actual.add(stacks.stackA.pop())
        actual.add(stacks.stackB.pop())
        actual.add(stacks.stackB.pop())
        actual.add(stacks.stackC.pop())
        actual.add(stacks.stackC.pop())
        actual.add(stacks.stackC.pop())

        // then
        assertEquals(listOf("A1", "B2", "B1", "C3", "C2", "C1"), actual)
        assertEquals(30, stacks.array.size)
    }

    @Test
    fun `push each with resize all stacks`() {
        // given
        val stacks = ThreeStacksArray<String>()

        // when
        stacks.stackA.apply {
            for (i in 1..11) {
                push("A$i")
            }
            for (i in 1..11) {
                pop()
            }
        }
        stacks.stackB.apply {
            for (i in 1..11) {
                push("B$i")
            }
        }
        stacks.stackC.apply {
            for (i in 1..11) {
                push("C$i")
            }
        }
        stacks.stackB.apply {
            for (i in 1..11) {
                pop()
            }
        }
        stacks.stackC.apply {
            for (i in 1..11) {
                pop()
            }
        }

        // then
        assertArrayEquals(arrayOfNulls(90), stacks.array)
    }

    @Test
    fun `push each resize of stack A`() {
        // given
        val stacks = ThreeStacksArray<String>()

        // when
        stacks.stackA.apply {
            for (i in 1..11) {
                push("A$i")
            }
            for (i in 1..11) {
                pop()
            }
        }
        stacks.stackB.apply {
            for (i in 1..10) {
                push("B$i")
            }
            for (i in 1..10) {
                pop()
            }
        }
        stacks.stackC.apply {
            for (i in 1..10) {
                push("B$i")
            }
            for (i in 1..10) {
                pop()
            }
        }

        // then
        assertArrayEquals(arrayOfNulls(50), stacks.array)
    }

    @Test
    fun `push each resize of stack B`() {
        // given
        val stacks = ThreeStacksArray<String>()

        // when
        stacks.stackA.apply {
            for (i in 1..10) {
                push("A$i")
            }
            for (i in 1..10) {
                pop()
            }
        }
        stacks.stackB.apply {
            for (i in 1..11) {
                push("B$i")
            }
            for (i in 1..11) {
                pop()
            }
        }
        stacks.stackC.apply {
            for (i in 1..10) {
                push("B$i")
            }
            for (i in 1..10) {
                pop()
            }
        }

        // then
        assertArrayEquals(arrayOfNulls(50), stacks.array)
    }

    @Test
    fun `push each resize of stack C`() {
        // given
        val stacks = ThreeStacksArray<String>()

        // when
        stacks.stackA.apply {
            for (i in 1..10) {
                push("A$i")
            }
            for (i in 1..10) {
                pop()
            }
        }
        stacks.stackB.apply {
            for (i in 1..10) {
                push("B$i")
            }
            for (i in 1..10) {
                pop()
            }
        }
        stacks.stackC.apply {
            for (i in 1..11) {
                push("B$i")
            }
            for (i in 1..11) {
                pop()
            }
        }

        // then
        assertArrayEquals(arrayOfNulls(50), stacks.array)
    }
}
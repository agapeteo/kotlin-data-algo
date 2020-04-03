package tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UnbalancedBinarySearchTreeTest {

    @Test
    fun `add and check elements count`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(5)
            add(12)
            add(1)
            add(2)
        }

        // then
        assertEquals(4, tree.elements().size)
    }

    @Test
    fun `ordered elements`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(5)
            add(12)
            add(1)
            add(2)
        }

        // then
        assertEquals(listOf(1, 2, 5, 12), tree.orderedElements())
    }

    @Test
    fun `contains value`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(5)
            add(12)
            add(1)
            add(2)
        }

        // then
        assertTrue(tree.contains(5))
        assertTrue(tree.contains(12))
        assertTrue(tree.contains(1))
        assertTrue(tree.contains(2))
        assertFalse(tree.contains(3))
    }

    @Test
    fun `should not contain in empty tree`() {
        // given
        // when
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        // then
        assertFalse(tree.contains(3))
    }

    @Test
    fun `depth - only root`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(3)
        }

        // then
        assertEquals(0, tree.depth())
    }

    @Test
    fun `depth - one level`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(3)
            add(2)
        }

        // then
        assertEquals(1, tree.depth())
    }

    @Test
    fun `depth - two levels`() {
        // given
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // when
        tree.apply {
            add(5)
            add(3)
            add(4)
            add(6)
        }

        // then
        assertEquals(2, tree.depth())
    }

    @Test
    fun `depth - empty tree`() {
        // given
        // when
        val tree: BinarySearchTree<Int> = UnbalancedBinarySearchTree()

        // then
        assertEquals(0, tree.depth())
    }

    @Test
    fun `sorted array to balanced tree`() {
        // given
        val example = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val tree = UnbalancedBinarySearchTree<Int>()
        tree.toTree(example)
    }

//    @Test
//    fun `check balanced`() {
//        // given
//        val example = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//        val tree = UnbalancedBinarySearchTree<Int>()
//        tree.toTree(example)
//
//        // when
//        val actual = tree.checkBalanced()
//
//        // then
//        assertTrue(actual)
//    }

    @Test
    fun `check balanced`() {
        // given
        val tree = UnbalancedBinarySearchTree<Int>()
        tree.add(6)
        tree.add(4)
        tree.add(3)
        tree.add(5)

        tree.add(9)
        tree.add(8)
        tree.add(10)


        // when
        val actual = tree.checkBalanced()

        // then
        assertTrue(actual)
    }

    @Test
    fun `check not balanced`() {
        // given
        val tree = UnbalancedBinarySearchTree<Int>()
        tree.add(1)
        tree.add(2)
        tree.add(3)

        tree.add(-1)
        tree.add(-2)
        tree.add(-3)

        // when
        val actual = tree.checkBalanced()

        // then
        assertFalse(actual)
    }

    @Test
    fun `check not balanced - ascending`() {
        // given
        val tree = UnbalancedBinarySearchTree<Int>()
        tree.add(1)
        tree.add(2)
        tree.add(3)

        // when
        val actual = tree.checkBalanced()

        // then
        assertFalse(actual)
    }

    @Test
    fun `check BST balanced - true`() {
        // given
        val tree = UnbalancedBinarySearchTree<Int>()
        tree.add(6)
        tree.add(4)
        tree.add(3)
        tree.add(5)

        tree.add(9)
        tree.add(8)
        tree.add(10)


        // when
        val actual = tree.checkBST()

        // then
        assertTrue(actual)
    }

    @Test
    fun bla() {
        val base = 10
        var n = 1234
        val list = mutableListOf<Int>()

        while (n != 0) {
            list.add(n % base)
            n /= base
        }
        println(list)
        var result = 0

        for (i in 0 until list.size) {
            var k = 1
            if (i != list.size - 1) {
                for (j in 0 until list.size - i - 1) {
                    k *= 10
                }
            }
            result += list[i] * k
        }

        println(result)
    }

}
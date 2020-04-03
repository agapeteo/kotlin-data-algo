package tree

import java.util.*
import kotlin.math.abs
import kotlin.math.max

class UnbalancedBinarySearchTree<E : Comparable<E>> : BinarySearchTree<E> {

    private var root: Node<E>? = null

    private data class Node<E>(val value: E, var left: Node<E>? = null, var right: Node<E>? = null)

    override fun add(value: E) {
        if (root == null) {
            root = Node(value)
            return
        }

        addNode(root!!, value)
    }

    private fun addNode(rootNode: Node<E>, value: E) {
        if (value <= rootNode.value) {
            if (rootNode.left == null) {
                rootNode.left = Node(value)
            } else {
                addNode(rootNode.left!!, value)
            }
        } else {
            if (rootNode.right == null) {
                rootNode.right = Node(value)
            } else {
                addNode(rootNode.right!!, value)
            }
        }
    }

    override fun elements(): List<E> {
        if (root == null) return listOf()

        val result = mutableListOf<E>()

        addRootElements(root, result)

        return result
    }

    private fun addRootElements(root: Node<E>?, list: MutableList<E>) {
        if (root == null) return

        list.add(root.value)
        addRootElements(root.left, list)
        addRootElements(root.right, list)
    }

    override fun contains(value: E): Boolean {
        if (root == null) return false

        return containsFromRoot(root, value)
    }

    private fun containsFromRoot(root: Node<E>?, value: E): Boolean {
        if (root == null) return false

        if (root.value == value) return true

        return if (value < root.value) {
            containsFromRoot(root.left, value)
        } else {
            containsFromRoot(root.right, value)
        }
    }

    override fun orderedElements(): List<E> {
        if (root == null) return listOf()

        val result = mutableListOf<E>()
        addElement(root, result)
        return result
    }

    private fun addElement(node: Node<E>?, list: MutableList<E>) {
        if (node == null) return

        addElement(node.left, list)
        list.add(node.value)
        addElement(node.right, list)
    }

    override fun depth(): Int {
        if (root == null) return 0

        return depthNode(root!!, 0)
    }

    private fun depthNode(node: Node<E>, curDepth: Int): Int {
        return max(
                if (node.left == null) {
                    curDepth
                } else {
                    depthNode(node.left!!, curDepth + 1)
                }, if (node.right == null) {
            curDepth
        } else {
            depthNode(node.right!!, curDepth + 1)
        })
    }

    fun toTree(sortedArray: Array<E>): BinarySearchTree<E> {
        root = toTree(sortedArray, 0, sortedArray.size)
        return this
    }

    private fun toTree(sortedArray: Array<E>, startIdx: Int, endIdx: Int): Node<E>? {
        if (endIdx <= startIdx) return null

        val midIdx = (endIdx - startIdx) / 2 + startIdx

        val root = Node(sortedArray[midIdx])
        root.left = toTree(sortedArray, startIdx, midIdx)
        root.right = toTree(sortedArray, midIdx + 1, endIdx)

        return root
    }

    fun checkBalanced(): Boolean {
//        return height(root) != -1
        return balanced()

    }

    private fun height(node: Node<E>?): Int {
        if (node == null) return 0

        val leftHeight = height(node.left)
        if (leftHeight == -1) return -1

        val rightHeight = height(node.right)
        if (rightHeight == -1) return -1

        if (abs(leftHeight - rightHeight) > 1) {
            return -1
        }
        return max(leftHeight, rightHeight) + 1
    }

    fun checkBST(): Boolean {
        fun checkBst(node: Node<E>, min: Node<E>?, max: Node<E>?): Boolean {
            if (min != null && node.value < min.value || max != null && node.value >= max.value) return false
            if (node.left != null) {
                if (!(checkBst(node.left!!, min, node))) return false
            }
            if (node.right != null) {
                if (!checkBst(node.right!!, node, max)) return false
            }
            return true
        }
        if (root == null) return true
        return checkBst(root!!, null, null)
    }


    private fun balanced(): Boolean {
        if (root == null) return true

        val stack: Deque<NodeStats<E>> = LinkedList()
        stack.push(nodeStats(root!!, null))

        while (stack.isNotEmpty()) {
            val curNodeStats = stack.pop()

            if (abs(curNodeStats.leftHeight - curNodeStats.rightHeight) > 1) return false

            if (curNodeStats.node.left == null && curNodeStats.node.right == null) {
                if (curNodeStats.parent == null) return true

                if (curNodeStats.node === curNodeStats.parent!!.node.left) {
                    curNodeStats.parent!!.node.left = null
                    curNodeStats.parent!!.leftHeight = curNodeStats.leftHeight + 1
                } else {
                    curNodeStats.parent!!.node.right = null
                    curNodeStats.parent!!.rightHeight = curNodeStats.rightHeight + 1
                }
                continue
            }

            stack.push(curNodeStats)
            if (curNodeStats.node.right != null) {
                stack.push(nodeStats(curNodeStats.node.right!!, curNodeStats))
            }
            if (curNodeStats.node.left != null) {
                stack.push(nodeStats(curNodeStats.node.left!!, curNodeStats))
            }
        }
        return true
    }

    private data class NodeStats<E>(
            val node: Node<E>,
            var leftHeight: Int = 0,
            var rightHeight: Int = 0,
            var parent: NodeStats<E>? = null)

    private fun nodeStats(node: Node<E>, parent: NodeStats<E>?): NodeStats<E> {
        val nodeStats = NodeStats(node)
        nodeStats.parent = parent
        return nodeStats
    }

}

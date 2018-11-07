package tree


class UnbalancedBinarySearchTree<E: Comparable<E>> : BinarySearchTree<E> {

    private var root: Node<E>? = null

    private data class Node<E>(val value: E, var left: Node<E>? = null, var right: Node<E>? = null)

    override fun add(value: E){
        if (root == null) {
            root = Node(value)
            return
        }

        addNode(root!!, value)
    }

    private fun addNode(rootNode: Node<E>, value: E) {
        if (value <= rootNode.value){
            if (rootNode.left == null){
                rootNode.left = Node(value)
            } else {
                addNode(rootNode.left!!, value)
            }
        } else {
            if (rootNode.right == null){
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

    override fun contains(value: E): Boolean{
        if (root == null) return false

        return containsFromRoot(root, value);
    }

    private fun containsFromRoot(root: Node<E>?, value: E): Boolean {
        if (root == null) return false

        if (root.value == value) return true

        if (value < root.value) {
            return containsFromRoot(root.left, value)
        } else {
            return containsFromRoot(root.right, value)
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

    override fun depth(): Int{
        if (root == null) return 0;

        return depthNode(root!!, 0)
    }

    private fun depthNode(node: Node<E>, curDepth: Int): Int {
        return Math.max(
            if (node.left == null) { curDepth } else { depthNode(node.left!!, curDepth + 1) },
            if (node.right == null) { curDepth } else { depthNode(node.right!!, curDepth + 1) }
        )
    }


}

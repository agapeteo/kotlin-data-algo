package trie

class SimpleTrie : Trie {

    private data class Node(val childrenMap: HashMap<Char, Node> = HashMap(), var isLast: Boolean = false)

    private val root = Node()

    override fun add(str: String) {

        fun add(charIdx: Int, node: Node) {
            if (charIdx >= str.length) return

            val curChar = str[charIdx]
            var curNode = node.childrenMap[curChar]

            if (curNode == null) {
                curNode = Node()
                node.childrenMap[curChar] = curNode
            }
            if (charIdx == str.length - 1) {
                curNode.isLast = true
            }
            add(charIdx + 1, curNode)
        }
        add(0, root)
    }

    override fun contains(str: String): Boolean {
        fun contains(charIdx: Int, node: Node): Boolean {
            if (charIdx >= str.length) return false

            val curChar = str[charIdx]
            val curNode = node.childrenMap[curChar] ?: return false

            if (charIdx == str.length - 1 && curNode.isLast) return true

            return contains(charIdx + 1, curNode)
        }
        return contains(0, root)
    }
}
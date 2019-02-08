package trie

class SimpleTrie : Trie {

    private data class Node(val char: Char, val childrenMap: HashMap<Char, Node> = HashMap())

    private val root = Node('*')

    override fun add(str: String) {

        fun add(charIdx: Int, node: Node) {
            if (charIdx >= str.length) return

            val curChar = str[charIdx]
            var curNode = node.childrenMap[curChar]

            if (curNode == null) {
                curNode = Node(curChar)
                node.childrenMap[curChar] = curNode
            }

            add(charIdx + 1, curNode)
        }
        add(0, root)
    }

    override fun contains(str: String): Boolean {
        fun contains(charIdx: Int, node: Node): Boolean {
            if (charIdx >= str.length) return true

            val curChar = str[charIdx]
            val curNode = node.childrenMap[curChar] ?: return false

            return contains(charIdx + 1, curNode)
        }
        return contains(0, root)
    }

}
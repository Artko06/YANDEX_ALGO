package tasks8_divB

data class TreeNode(
    var left: TreeNode? = null,
    var right: TreeNode? = null,
    var parent: TreeNode? = null,
    var type: String = "root"
)

fun buildTree(serialized: String): TreeNode {
    val tree = TreeNode(type = "root")
    var node = tree
    for (ch in serialized) {
        when (ch) {
            'D' -> {
                val newNode = TreeNode(parent = node, type = "left")
                node.left = newNode
                node = newNode
            }
            'U' -> {
                while (node.type == "right") {
                    node = node.parent!!
                }
                node = node.parent!!
                val newNode = TreeNode(parent = node, type = "right")
                node.right = newNode
                node = newNode
            }
        }
    }
    return tree
}

fun traverse(root: TreeNode, prefix: MutableList<String>): List<String> {
    if (root.left == null && root.right == null) {
        return listOf(prefix.joinToString(""))
    }

    val leafCodes = mutableListOf<String>()
    prefix.add("0")
    leafCodes.addAll(traverse(root.left!!, prefix))
    prefix.removeAt(prefix.size - 1)

    prefix.add("1")
    leafCodes.addAll(traverse(root.right!!, prefix))
    prefix.removeAt(prefix.size - 1)

    return leafCodes
}

fun getLeafCodes(s: String): List<String> {
    val tree = buildTree(s)
    return traverse(tree, mutableListOf())
}

fun main() {
    val input = System.`in`.bufferedReader()
    val n = input.readLine().toInt()
    val answer = mutableListOf<String>()

    repeat(n) {
        val codes = getLeafCodes(input.readLine())
        answer.add(codes.size.toString())
        answer.addAll(codes)
    }

    println(answer.joinToString("\n"))
}
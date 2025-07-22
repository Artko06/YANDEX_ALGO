package tasks8.taskI

class GenTree {
    val nodes = mutableMapOf<String, Node>()

    class Node(
        val name: String,
        var parent: Node? = null
    ) {
        val children = mutableListOf<Node>()
        var descendantCount = 0
    }

    fun buildDescendantsCount(node: Node): Int {
        var total = 0
        for (child in node.children) {
            total += buildDescendantsCount(child) + 1
        }
        node.descendantCount = total

        return total
    }
}

fun main() {
    val genTree = GenTree()

    val n = readLine()!!.toInt()

    repeat(n - 1) {
        val (childName, parentName) = readLine()!!.split(" ")

        val parentNode = genTree.nodes.getOrPut(parentName) { GenTree.Node(parentName) }
        val childNode = genTree.nodes.getOrPut(childName) { GenTree.Node(childName) }

        childNode.parent = parentNode
        parentNode.children.add(childNode)
    }

    val root = genTree.nodes.values.first { it.parent == null }
    genTree.buildDescendantsCount(root)

    genTree.nodes.toSortedMap().forEach { (name, node) ->
        println("$name ${node.descendantCount}")
    }
}

package tasks8.taskJ

class GenTree {
    val nodes = mutableMapOf<String, Node>()

    class Node(
        val name: String,
        var parent: Node? = null
    ) {
        val children = mutableListOf<Node>()
        var height = 0
    }

    fun buildHeights(node: Node, currentHeight: Int = 0) {
        node.height = currentHeight
        for (child in node.children) {
            buildHeights(child, currentHeight + 1)
        }
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

    // Найдём корень (у кого нет родителя)
    val root = genTree.nodes.values.first { it.parent == null }

    // Вычислим высоты
    genTree.buildHeights(root)

    // Выводим в лексикографическом порядке
    genTree.nodes.toSortedMap().forEach { (name, node) ->
        println("$name ${node.height}")
    }
}

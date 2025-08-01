package tasks8_divB

class GenTree{
    val nodes = mutableMapOf<String, Node>()

    data class Node(
        val name: String = "",
        var parent: Node? = null
    )

    fun isAncestor(ancestor: String, descendant: String): Boolean {
        val descendantNode = nodes[descendant]!!

        var parentNode = descendantNode.parent
        while (parentNode != null) {
            if (parentNode.name == ancestor) return true
            parentNode = parentNode.parent
        }

        return false
    }
}

fun main() {
    val genTree = GenTree()
    val n = readLine()!!.toInt()

    repeat(n - 1) {
        val (childName, parentName) = readLine()!!.split(' ')

        val parentNode = genTree.nodes.getOrPut(parentName) { GenTree.Node(name = parentName) }

        val childNode = genTree.nodes[childName]
        if (childNode == null) {
            genTree.nodes.put(childName, GenTree.Node(name = childName, parent = parentNode))
        } else {
            childNode.parent = parentNode
        }
    }

    val reader = System.`in`.bufferedReader()
    val answer = StringBuilder()
    reader.lineSequence().forEach { line ->
        val (name1, name2) = line.split(' ')

        when{
            genTree.isAncestor(name1, name2) -> answer.append("1 ")
            genTree.isAncestor(name2, name1) -> answer.append("2 ")
            else -> answer.append("0 ")
        }
    }

    println(answer)
}
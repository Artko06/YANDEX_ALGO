 package tasks8_divB

class GenericTree{
    val nodes = mutableMapOf<String, Node>()

    data class Node(
        val name: String = "",
        var parent: Node? = null
    )
}

fun main() {
    val genTree = GenericTree()
    val n = readLine()!!.toInt()

    repeat(n - 1) {
        val (childName, parentName) = readLine()!!.split(' ')

        val parentNode = genTree.nodes.getOrPut(parentName) { GenericTree.Node(name = parentName) }

        val childNode = genTree.nodes[childName]
        if (childNode == null) {
            genTree.nodes.put(childName, GenericTree.Node(name = childName, parent = parentNode))
        } else {
            childNode.parent = parentNode
        }
    }

    val reader = System.`in`.bufferedReader()
    val answer = StringBuilder()
    reader.lineSequence().forEach { line ->
        val (name1, name2) = line.split(' ')

        var tempAncestorsNode1 = genTree.nodes[name1]
        val ancestorsForNode1 = mutableSetOf<String>()

        while (tempAncestorsNode1 != null) {
            ancestorsForNode1.add(tempAncestorsNode1.name)
            tempAncestorsNode1 = tempAncestorsNode1.parent
        }

        var tempAncestorsNode2 = genTree.nodes[name2]

        while (tempAncestorsNode2 != null) {
            if (tempAncestorsNode2.name in ancestorsForNode1) {
                answer.append("${tempAncestorsNode2.name}\n")
                break
            }
            tempAncestorsNode2 = tempAncestorsNode2.parent
        }
    }

    println(answer)
}
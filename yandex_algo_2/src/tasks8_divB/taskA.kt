package tasks8_divB

class BST<T: Comparable<T>> {
    class Node<T: Comparable<T>>(var value: T){
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    private var root: Node<T>? = null

    fun insert(value: T): Node<T> {
        root = insert(value, root)
        return root!!
    }

    private fun insert(value: T, node: Node<T>?): Node<T> {
        if (node == null) {
            return Node(value)
        }

        when {
            value > node.value -> node.right = insert(value, node.right)
            value < node.value -> node.left = insert(value, node.left)
        }

        return node
    }

    fun contains(value: T): Boolean {
        return contains(value, root)
    }

    private fun contains(value: T, node: Node<T>?): Boolean {
        if (node == null) return false

        return when {
            value == node.value -> true
            value < node.value -> contains(value, node.left)
            else -> contains(value, node.right)
        }
    }

    fun depth(value: T): Int {
        return depth(root, value, 0)
    }

    private fun depth(node: Node<T>?, value: T, currentDepth: Int): Int {
        if (node == null) return -1

        return when {
            value == node.value -> currentDepth
            value < node.value -> depth(node.left, value, currentDepth + 1)
            else -> depth(node.right, value, currentDepth + 1)
        }
    }

    // Симметричный обход - (левое - корень - правое)
    fun inOrder(): List<T> {
        val list = mutableListOf<T>()
        inOrder(root, list)

        return list
    }

    private fun inOrder(node: Node<T>?, list: MutableList<T>) {
        if (node != null) {
            inOrder(node.left, list)
            list.add(node.value)
            inOrder(node.right, list)
        }
    }
}

fun main() {
    val bst = BST<Int>()

    val reader = System.`in`.bufferedReader()
    val answer = StringBuilder()
    reader.lineSequence().forEach { line ->
        if (line != "PRINTTREE") {
            val (command, number) = line.split(" ")

            val intNumber = number.toInt()
            when (command) {
                "ADD" -> {
                    if (bst.contains(intNumber)) answer.append("ALREADY\n")
                    else {
                        bst.insert(intNumber)
                        answer.append("DONE\n")
                    }
                }

                "SEARCH" -> {
                    if (bst.contains(intNumber)) answer.append("YES\n")
                    else answer.append("NO\n")
                }
            }
        } else {
            val inOrder = bst.inOrder()

            inOrder.forEach { number ->
                val depth = bst.depth(number)

                val dots = StringBuilder()
                repeat(depth) {
                    dots.append('.')
                }
                answer.append("$dots$number\n")
            }
        }
    }

    println(answer)
}
package tasks8.taskA

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

    fun height(): Int {
        return height(root)
    }

    private fun height(node: Node<T>?): Int {
        if (node == null) return 0

        val leftHeight = height(node.left)
        val rightHeight = height(node.right)

        return if (leftHeight > rightHeight) leftHeight + 1
        else rightHeight + 1
    }
}

fun main() {
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val tree = BST<Int>()

    numbers.forEach { number ->
        if (number != 0) {
            tree.insert(number)
        }
    }

    println(tree.height())
}
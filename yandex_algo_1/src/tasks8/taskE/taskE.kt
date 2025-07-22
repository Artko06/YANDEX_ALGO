package tasks8.taskE

class BST<T: Comparable<T>> {
    class Node<T: Comparable<T>>(var value: T){
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    private var root: Node<T>? = null

    fun insert(value: T): Node<T>? {
        root = insert(value, root)
        return root
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

    fun leafOrder(): List<T> {
        val list = mutableListOf<T>()
        leafOrder(root, list)
        return list
    }

    private fun leafOrder(node: Node<T>?, mutableList: MutableList<T>) {
        if (node != null) {
            if (node.left == null && node.right == null) mutableList.add(node.value)
            leafOrder(node.left, mutableList)
            leafOrder(node.right, mutableList)
        }

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

    tree.leafOrder().forEach { println(it) }
}
package tasks8.taskG

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

    fun oneChildrenOrder(): List<T> {
        val list = mutableListOf<T>()
        oneChildrenOrder(root, list)
        return list
    }

    private fun oneChildrenOrder(node: Node<T>?, mutableList: MutableList<T>) {
        if (node != null) {
            oneChildrenOrder(node.left, mutableList)
            if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
                mutableList.add(node.value)
            }
            oneChildrenOrder(node.right, mutableList)
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

    tree.oneChildrenOrder().forEach { println(it) }
}
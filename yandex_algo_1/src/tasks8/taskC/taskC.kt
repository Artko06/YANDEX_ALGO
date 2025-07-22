package tasks8.taskC

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

    fun inOrder(): List<T> {
        val list = mutableListOf<T>()
        inOrder(root, list)
        return list
    }

    private fun inOrder(node: Node<T>?, mutableList: MutableList<T>) {
        if (node != null) {
            inOrder(node.left, mutableList)
            mutableList.add(node.value)
            inOrder(node.right, mutableList)
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

    val sortedNumbers = tree.inOrder()
    println(sortedNumbers[sortedNumbers.size - 2])
}
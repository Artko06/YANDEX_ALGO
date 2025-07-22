package tasks8.taskB

class BST<T: Comparable<T>> {
    class Node<T: Comparable<T>>(var value: T){
        var left: Node<T>? = null
        var right: Node<T>? = null
    }

    private var root: Node<T>? = null

    private var counterHeightInsert = 1

    fun insert(value: T): Int {
        counterHeightInsert = 1

        root = insert(value, root)
        return counterHeightInsert
    }

    private fun insert(value: T, node: Node<T>?): Node<T> {
        if (node == null) {
            return Node(value)
        }

        when {
            value > node.value -> {
                counterHeightInsert++
                node.right = insert(value, node.right)
            }
            value < node.value -> {
                counterHeightInsert++
                node.left = insert(value, node.left)
            }
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
}

fun main(){
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val tree = BST<Int>()

    numbers.forEach { number ->
        if (number != 0 && !tree.contains(number)) {
            print(tree.insert(number).toString() + " ")
        }
    }
}
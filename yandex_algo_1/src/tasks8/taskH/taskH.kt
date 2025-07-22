package tasks8.taskH

import kotlin.math.abs
import kotlin.math.max

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

    fun isBalanced(): Boolean {
        return checkBalance(root) != -1
    }

    private fun checkBalance(node: Node<T>?): Int {
        if (node == null) return 0

        val leftHeight = checkBalance(node.left)
        if (leftHeight == -1) return -1

        val rightHeight = checkBalance(node.right)
        if (rightHeight == -1) return -1

        return if (abs(leftHeight - rightHeight) > 1) -1
        else max(leftHeight, rightHeight) + 1
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

    val balance = tree.isBalanced()
    when(balance){
        true -> println("YES")
        false -> println("NO")
    }
}
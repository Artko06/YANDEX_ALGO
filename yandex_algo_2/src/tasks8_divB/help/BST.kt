package info

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

    fun remove(value: T): Node<T> {
        root = remove(value, root)
        return root!!
    }

    private fun remove(value: T, node: Node<T>?): Node<T>? {
        if (node == null) return null

        when {
            value > node.value -> {
                node.right = remove(value, node.right)
                return node
            }

            value < node.value -> {
                node.left = remove(value, node.left)
                return node
            }

            else -> {
                if (node.left == null) return node.right
                else if (node.right == null) return node.left

                // two children
                val minRightTree = findMin(node.right!!)
                node.value = minRightTree.value
                node.right = remove(minRightTree.value, node.right)

                return node
            }
        }
    }

    private fun findMin(node: Node<T>): Node<T> {
        var currentNode = node

        while (currentNode.left != null) {
            currentNode = currentNode.left!!
        }

        return currentNode
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

    // Прямой обход - корень ДО(pre) поддеревьев (корень - левое - правое)
    fun preOrder(): List<T> {
        val list = mutableListOf<T>()
        preOrder(root, list)

        return list
    }

    private fun preOrder(node: Node<T>?, list: MutableList<T>) {
        if (node != null) {
            list.add(node.value)
            preOrder(node.left, list)
            preOrder(node.right, list)
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

    // Обратный обход - (левое - правое - корень)
    fun postOrder(): List<T> {
        val list = mutableListOf<T>()
        postOrder(root, list)

        return list
    }

    private fun postOrder(node: Node<T>?, list: MutableList<T>) {
        if (node != null) {
            postOrder(node.left, list)
            postOrder(node.right, list)
            list.add(node.value)
        }
    }
}
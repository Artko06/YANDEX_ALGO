package stack.help

class Stack<T> {
    private var top: Node<T>? = null
    private var size: Int = 0

    data class Node<T>(
        val value: T,
        val next: Node<T>? = null
    )

    fun pop(): T? {
        if (isEmpty()) return null
        val value = top?.value
        top = top?.next
        size--
        return value
    }

    fun push(value: T) {
        val newNode = Node(value, top)
        top = newNode
        size++
    }

    fun peek(): T? {
        return top?.value
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun clear() {
        while (!isEmpty()) {
            top = top?.next
            size--
        }
    }

    fun size(): Int {
        return size
    }
}
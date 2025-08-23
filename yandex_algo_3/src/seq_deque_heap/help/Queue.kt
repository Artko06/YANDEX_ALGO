package seq_deque_heap.help

class Queue<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    var size = 0
        private set

    private data class Node<T>(
        var next: Node<T>? = null,
        val value: T
    )

    fun push(value: T) {
        val newNode = Node(value = value)
        if (first == null) {
            first = newNode
            last = newNode
        } else {
            last!!.next = newNode
            last = newNode
        }
        size++
    }

    fun peek() = first?.value

    fun pop(): T? {
        if (first == null) return null
        val popFirst = first
        first = first!!.next
        if (first == null) last = null
        size--
        return popFirst?.value
    }

    fun isEmpty() = size == 0

    fun isNotEmpty() = size != 0

    fun clear() {
        first = null
        last = null
        size = 0
    }
}
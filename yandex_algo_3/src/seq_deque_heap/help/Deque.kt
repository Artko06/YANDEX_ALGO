package seq_deque_heap.help

class Deque<T> {
    private var front: Node<T>? = null
    private var back: Node<T>? = null
    var size = 0
        private set

    private data class Node<T>(
        var next: Node<T>? = null,
        var previous: Node<T>? = null,
        val value: T
    )

    fun pushBack(value: T) {
        val newNode = Node(value = value, previous = back)
        if (back == null) {
            back = newNode
            front = newNode
        } else {
            back!!.next = newNode
            back = newNode
        }
        size++
    }

    fun pushFront(value: T) {
        val newNode = Node(value = value, next = front)
        if (front == null) {
            front = newNode
            back = newNode
        } else {
            front!!.previous = newNode
            front = newNode
        }
        size++
    }

    fun peekFront(): T? = front?.value

    fun peekBack(): T? = back?.value

    fun popFront(): T? {
        if (front == null) return null
        val popNode = front
        front = front!!.next
        if (front == null) back = null
        size--
        return popNode!!.value
    }

    fun popBack(): T? {
        if (back == null) return null
        val popNode = back
        back = back!!.previous
        if (back == null) front = null
        size--
        return popNode!!.value
    }

    fun isEmpty() = size == 0

    fun isNotEmpty() = size != 0

    fun clear() {
        size = 0
        back = null
        front = null
    }
}
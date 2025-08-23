package seq_deque_heap

class Queue16<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    var size = 0
        private set

    data class Node<T>(
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

    fun clear() {
        first = null
        last = null
        size = 0
    }
}

fun main() {
    val queue = Queue16<Int>()
    val reader = System.`in`.bufferedReader()

    val writer = System.out.bufferedWriter()
    reader.lineSequence().forEach { line ->
        val input = line.split(' ')

        when (input[0]) {
            "push" -> {
                queue.push(input[1].toInt())
                writer.write("ok\n")
            }

            "pop" -> {
                if (queue.peek() != null) {
                    writer.write("${queue.pop()}\n")
                } else {
                    writer.write("error\n")
                }
            }

            "front" -> {
                val value = queue.peek()
                if (value != null) {
                    writer.write("$value\n")
                } else {
                    writer.write("error\n")
                }
            }

            "size" -> {
                writer.write("${queue.size}\n")
            }

            "clear" -> {
                queue.clear()
                writer.write("ok\n")
            }

            "exit" -> {
                writer.write("bye\n")
                writer.flush()
            }
        }
    }
}
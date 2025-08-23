package seq_deque_heap

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
        else front!!.previous = null
        size--
        return popNode!!.value
    }

    fun popBack(): T? {
        if (back == null) return null
        val popNode = back
        back = back!!.previous
        if (back == null) front = null
        else back!!.next = null
        size--
        return popNode!!.value
    }

    fun clear() {
        size = 0
        back = null
        front = null
    }
}

fun main() {
    val deque = Deque<Int>()
    val reader = System.`in`.bufferedReader()

    val writer = System.out.bufferedWriter()
    while (true) {
        val line = reader.readLine() ?: break
        val input = line.split(' ')

        when (input[0]) {
            "push_front" -> {
                deque.pushFront(input[1].toInt())
                writer.write("ok\n")
            }

            "push_back" -> {
                deque.pushBack(input[1].toInt())
                writer.write("ok\n")
            }

            "pop_front" -> {
                if (deque.peekFront() != null) {
                    writer.write("${deque.popFront()}\n")
                } else {
                    writer.write("error\n")
                }
            }

            "pop_back" -> {
                if (deque.peekBack() != null) {
                    writer.write("${deque.popBack()}\n")
                } else {
                    writer.write("error\n")
                }
            }

            "front" -> {
                val value = deque.peekFront()
                if (value != null) {
                    writer.write("$value\n")
                } else {
                    writer.write("error\n")
                }
            }

            "back" -> {
                val value = deque.peekBack()
                if (value != null) {
                    writer.write("$value\n")
                } else {
                    writer.write("error\n")
                }
            }

            "size" -> {
                writer.write("${deque.size}\n")
            }

            "clear" -> {
                deque.clear()
                writer.write("ok\n")
            }

            "exit" -> {
                writer.write("bye\n")
                writer.flush()
            }
        }
    }
}
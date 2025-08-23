package stack

class Stack11<T> {
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

    fun clear() {
        while (!isEmpty()) {
            top = top?.next
            size--
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun size(): Int {
        return size
    }
}

fun main() {
    val stack = Stack11<Int>()
    val reader = System.`in`.bufferedReader()

    val writer = System.out.bufferedWriter()
    reader.lineSequence().forEach { line ->
        val commandValue = line.split(' ')

        when (commandValue[0]) {
            "push" -> {
                stack.push(commandValue[1].toInt())
                writer.write("ok\n")
            }

            "pop" -> {
                val value = stack.pop()

                if (value == null) {
                    writer.write("error\n")
                } else writer.write("$value\n")
            }

            "back" -> {
                val value = stack.peek()

                if (value == null) {
                    writer.write("error\n")
                } else writer.write("$value\n")
            }

            "size" -> {
                writer.write(stack.size().toString() + "\n")
            }

            "clear" -> {
                stack.clear()
                writer.write("ok\n")
            }

            "exit" -> {
                writer.write("bye\n")
                writer.flush()
            }
        }
    }
}
package stack

class Stack13<T> {
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

    fun isEmpty(): Boolean {
        return size == 0
    }
}

fun main() {
    val stack = Stack13<Long>()
    val postfixLine = readln().split(" ")

    for (chars in postfixLine) {
        when(chars) {
            "+" -> {
                stack.push(stack.pop()!! + stack.pop()!!)
            }

            "-" -> {
                val value2 = stack.pop()!!
                val value1 = stack.pop()!!

                stack.push(value1 - value2)
            }

            "*" -> {
                stack.push(stack.pop()!! * stack.pop()!!)
            }
            else -> {
                stack.push(chars.toLong())
            }
        }
    }

    println(stack.pop())
}
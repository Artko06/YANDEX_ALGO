package stack

class Stack14<T> {
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

    fun size(): Int {
        return size
    }
}

fun main() {
    val stack = Stack14<Byte>()
    val n = readln().toByte()
    val numbers = readln().split(' ').map { it.toByte() }

    fun check(): Boolean {
        var nextNum: Byte = 1
        var left = 0
        while (left != numbers.size) {
            when (nextNum) {
                numbers[left] -> {
                    nextNum++
                    left++
                }
                stack.peek() -> {
                    stack.pop()
                    nextNum++
                }
                else -> {
                    stack.push(numbers[left])
                    left++
                }
            }
        }

        while (!stack.isEmpty()) {
            val num = stack.pop()
            if (num == nextNum) nextNum++
            else return false
        }

        return true
    }

    if (check()) println("YES")
    else println("NO")
}
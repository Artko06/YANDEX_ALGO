package stack

class Stack12<T> {
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
    val stack = Stack12<Char>()
    val str = readln()

    fun checkLine(str: String): Boolean {
        for (char in str) {
            if (char == '(' || char == '[' || char == '{') {
                stack.push(char)
            }
            else {
                val value = stack.pop()

                if (value == '(' && char != ')') return false
                else if (value == '{' && char != '}') return false
                else if (value == '[' && char != ']') return false
                else if (value == null) return false
            }
        }

        return stack.isEmpty()
    }


    if (checkLine(str)) println("yes")
    else println("no")
}
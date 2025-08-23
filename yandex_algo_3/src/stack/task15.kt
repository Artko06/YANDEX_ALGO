package stack

class Stack15<T> {
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
    val stack = Stack15<Pair<Int, Int>>()
    val n = readln().toInt()
    val prices = readln().split(' ').map { it.toInt() }

    val answer = MutableList(n) { -1 }
    prices.forEachIndexed { index, price ->
        while (!stack.isEmpty()) {
            val (indexInStack, priceInStack) = stack.peek()!!
            if (priceInStack <= price) break
            stack.pop()
            answer[indexInStack] = index
        }

        stack.push(Pair(index, price))
    }

    println(answer.joinToString(separator = " "))
}
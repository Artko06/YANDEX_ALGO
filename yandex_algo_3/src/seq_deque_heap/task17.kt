package seq_deque_heap

class Queue17<T> {
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

    fun pop(): T? {
        if (first == null) return null
        val popFirst = first
        first = first!!.next
        if (first == null) last = null
        size--
        return popFirst?.value
    }

    fun isEmpty() = size == 0
}

fun main() {
    val player1 = Queue17<Int>()
    val player2 = Queue17<Int>()

    readln().trim().split(' ').map { it.toInt() }.forEach { player1.push(it) }
    readln().trim().split(' ').map { it.toInt() }.forEach { player2.push(it) }

    var stepCounter = 0
    var winPlayer1 = false
    while (true) {
        if(player2.isEmpty()) {
            winPlayer1 = true
            break
        } else if (player1.isEmpty()) break

        val card1 = player1.pop()!!
        val card2 = player2.pop()!!
        stepCounter++

        if (card1 == 0 && card2 == 9) {
            player1.push(card1)
            player1.push(card2)
        } else if (card1 == 9 && card2 == 0) {
            player2.push(card1)
            player2.push(card2)
        } else if (card1 > card2) {
            player1.push(card1)
            player1.push(card2)
        } else {
            player2.push(card1)
            player2.push(card2)
        }
    }

    if (winPlayer1) {
        println("first $stepCounter")
    } else println("second $stepCounter")
}
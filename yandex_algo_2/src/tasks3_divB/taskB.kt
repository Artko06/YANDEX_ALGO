package tasks3_divB

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val set = mutableSetOf<Int>()

    input.forEach { num ->
        if (num in set) println("YES")
        else {
            set.add(num)
            println("NO")
        }
    }
}

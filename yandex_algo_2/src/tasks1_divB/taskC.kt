package tasks1_divB

fun main() {
    val (x, y, year) = readLine()!!.split(" ").map { it.toInt() }

    if (x > 12 || y > 12 || x == y) println(1)
    else println(0)
}
package tasks3_divB

fun main() {
    val set1 = readLine()!!.split(" ").map { it.toInt() }.toSet()
    val set2 = readLine()!!.split(" ").map { it.toInt() }.toSet()

    println(set1.intersect(set2).size)
}
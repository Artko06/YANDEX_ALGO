package tasks1_divB

fun main() {
    val n = readLine()!!.toInt()
    val coordinates = readLine()!!.split(" ").map { it.toInt() }

    println(coordinates[n / 2])
}
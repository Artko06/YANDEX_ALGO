package tasks1

fun main() {
    val temperatures = readLine()!!.split(" ").map { it.toInt() }
    val type = readLine()!!

    println(
        when (type) {
            "heat" -> if (temperatures[1] > temperatures[0]) temperatures[1] else temperatures[0]
            "freeze" -> if (temperatures[1] < temperatures[0]) temperatures[1] else temperatures[0]
            "auto" -> temperatures[1]
            "fan" -> temperatures[0]
            else -> 0
        }
    )
}
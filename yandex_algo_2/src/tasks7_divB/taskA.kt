package tasks7_divB

const val LEFT: Byte = 1
const val RIGHT: Byte = 2

fun main() {
    val n = readLine()!!.toInt()
    val inOutArray = mutableListOf<Pair<Byte, Int>>()

    repeat(n) { index ->
        val (left, right) = readLine()!!.split(" ").map { it.toInt() }

        inOutArray.add(Pair(LEFT, left))
        inOutArray.add(Pair(RIGHT, right))
    }
    inOutArray.sortWith(compareBy({ it.second }, { it.first }))

    var length = 0
    var countLeft = 0
    for(i in inOutArray.indices) {
        if(countLeft > 0) {
            length += inOutArray[i].second - inOutArray[i - 1].second
        }

        if (inOutArray[i].first == LEFT) countLeft++
        else countLeft--
    }

    println(length)
}
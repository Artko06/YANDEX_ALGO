package tasks2_divB

fun main() {
    val n = readLine()!!.toInt()
    val countDip = readLine()!!.split(" ").map { it.toInt() }

    var maxDip = 0
    var sumDip = 0
    for (i in 0 until n) {
        sumDip += countDip[i]
        if (maxDip < countDip[i]) maxDip = countDip[i]
    }

    println(sumDip - maxDip)
}
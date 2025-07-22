package tasks4

fun main() {
    val gMap = ('a'..'z').plus('A'..'Z').associateWith { 0 }.toMutableMap()
    val stepMap = ('a'..'z').plus('A'..'Z').associateWith { 0 }.toMutableMap()
    var counterWords = 0

    val (gSize, sSize) = readLine()!!.split(" ").map { it.toInt() }

    val gString = readLine()!!
    for (i in gString) {
        gMap[i] = gMap[i]!! + 1
    }

    val sString = readLine()!!
    for (i in 0 until gSize) {
        val stepS = sString[i]
        stepMap[stepS] = stepMap[stepS]!! + 1

    }
    if (gMap == stepMap) counterWords++

    for (i in gSize until sSize) {
        val removeStepS = sString[i - gSize]
        val stepS = sString[i]

        stepMap[removeStepS] = stepMap[removeStepS]!! - 1
        stepMap[stepS] = stepMap[stepS]!! + 1

        if (gMap == stepMap) counterWords++
    }

    println(counterWords)
}
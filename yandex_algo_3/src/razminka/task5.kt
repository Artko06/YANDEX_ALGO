package razminka

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val countLetters = MutableList(n) { 0L }

    repeat(n) {
        countLetters[it] = readln().toLong()
    }

    var beautifulStrCounter = 0L
    for (i in 0 until n - 1) {
        beautifulStrCounter += min(countLetters[i], countLetters[i + 1])
    }

    println(beautifulStrCounter)
}
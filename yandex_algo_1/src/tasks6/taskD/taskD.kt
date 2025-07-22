package tasks6.taskD

import kotlin.math.max

fun check(side1: Long, side2: Long, n: Long, w: Long, h: Long, d: Long): Boolean {
    val columns = h / (side1 + 2 * d)
    val rows = w / (side2 + 2 * d)
    val columns2 = h / (side2 + 2 * d)
    val rows2 = w / (side1 + 2 * d)

    return if (columns * rows >= n) true
    else if (columns2 * rows2 >= n) true
    else false
}

fun rBinSearch(n: Long, a: Long, b: Long, w: Long, h: Long): Long {
    var left: Long = 0
    var right: Long = max(h, w)

    while (left < right) {
        val mid: Long = (left + right + 1) / 2

        if (check(a, b, n, w, h, mid)) {
            left = mid
        } else right = mid - 1
    }

    return left
}

fun main() {
    val (n, a, b, w, h) = readLine()!!.split(" ").map { it.toLong() }

    println(rBinSearch(n, a, b, w, h))
}
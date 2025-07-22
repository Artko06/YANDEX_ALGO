package tasks6.taskF

import kotlin.math.max
import kotlin.math.min

fun lBinSearch(n: Long, x: Long, y: Long): Long {
    if (n == 0L) return 0

    var left: Long = min(x, y)
    var right: Long = n * max(x, y) // print tasks on the slowest printer

    while (left < right) {
        val mid: Long = (left + right) / 2

        if (mid / x + mid / y < n) {
            left = mid + 1
        } else right = mid
    }

    return left
}

fun main() {
    val (n, x, y) = readLine()!!.split(" ").map { it.toLong() }

    println(lBinSearch(n - 1, x, y) + min(x, y))
}
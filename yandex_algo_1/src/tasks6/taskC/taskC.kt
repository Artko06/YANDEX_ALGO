package tasks6.taskC

import kotlin.math.max

fun lBinSearch(w: Int, h: Int, n: Int): Long {
    var left: Long = 1
    var right: Long = max(w, h) * n.toLong()

    while (left < right) {
        val mid = (left + right) / 2

        if ((mid / w) * (mid / h) < n) {
            left = mid + 1
        } else right = mid
    }

    return left
}

fun main() {
    val (w, h, n) = readLine()!!.split(" ").map { it.toInt() }

    println(lBinSearch(w, h, n))
}
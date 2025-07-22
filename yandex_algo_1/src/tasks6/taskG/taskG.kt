package tasks6.taskG

import kotlin.math.min

fun rBinSearch(n: Long, m: Long, t: Long): Long {
    var left: Long = 0
    var right: Long = min(n, m) / 2

    while (left < right) {
        val mid: Long = (left + right + 1) / 2

        if (n * m - (n - 2 * mid) * (m - 2 * mid) > t){
            right = mid - 1
        } else left = mid
    }

    return left
}

fun main() {
    println(rBinSearch(readLine()!!.toLong(), readLine()!!.toLong(), readLine()!!.toLong()))
}
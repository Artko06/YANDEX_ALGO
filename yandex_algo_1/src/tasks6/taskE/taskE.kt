package tasks6.taskE

import tasks6.taskF.lBinSearch

fun lBinSearch(a: Long, b: Long, c: Long): Long {
    var left: Long = 0
    var right: Long = a + b + c

    while (left < right) {
        val mid: Long = (left + right) / 2

        // (a * 2 + b * 3 + c * 4 + mid * 5) / (a + b + c + mid) < 3.5
        if (-3 * a - b + c + 3 * mid < 0) {
            left = mid + 1
        } else right = mid
    }

    return left
}

fun main() {
    println(lBinSearch(readLine()!!.toLong(), readLine()!!.toLong(), readLine()!!.toLong()))
}
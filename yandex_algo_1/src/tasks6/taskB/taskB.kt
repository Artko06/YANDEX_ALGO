package tasks6.taskB

import kotlin.math.abs

fun lBinSearch(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (list[mid] < target) {
            left = mid + 1
        } else right = mid
    }

    return left
}

fun rBinSearch(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size - 1

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (list[mid] > target) {
            right = mid - 1
        } else left = mid
    }

    return left
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr1 = readLine()!!.trim().split(" ").map { it.toInt() }
    val arr2 = readLine()!!.trim().split(" ").map { it.toInt() }

    val strOutput = StringBuilder()
    arr2.forEach { num ->
        val lBinarySearch = lBinSearch(arr1, num)
        val rBinarySearch = rBinSearch(arr1, num)

        if (abs(arr1[rBinarySearch] - num) <= abs(arr1[lBinarySearch] - num)) {
            strOutput.append("${arr1[rBinarySearch]}\n")
        } else  strOutput.append("${arr1[lBinarySearch]}\n")
    }

    println(strOutput)
}
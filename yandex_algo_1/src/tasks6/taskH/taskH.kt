package tasks6.taskH

fun check(n: Int, k: Int, separator: Int, arr: List<Int>): Boolean{
    var sumCount = 0

    for(i in 0 until n) {
        sumCount += arr[i] / separator
    }

    return sumCount >= k
}

fun rBinSearch(n: Int, k: Int, arr: List<Int>): Int {
    var left = 0
    var right = arr.max()

    while (left < right){
        val mid = (left + right + 1) / 2

        if (check(n, k, mid, arr)) {
            left = mid
        } else right = mid - 1
    }

    return left
}

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val arr = mutableListOf<Int>()

    repeat(n){
        arr.add(readLine()!!.toInt())
    }

    println(rBinSearch(n, k, arr))
}
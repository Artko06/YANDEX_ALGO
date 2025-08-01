package tasks6_divB.taskA

fun lBinSearch(min: Int, arr: List<Int>): Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (arr[mid] < min) left = mid + 1
        else right = mid
    }

    return left
}

fun rBinSearch(max: Int, arr: List<Int>): Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (arr[mid] > max) right = mid - 1
        else left = mid
    }

    return left
}

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val k = readLine()!!.toInt()

    repeat(k) {
        val (min, max) = readLine()!!.split(" ").map { it.toInt() }

        val minIndex = lBinSearch(min, arr)
        val maxIndex = rBinSearch(max, arr)

        if (arr[minIndex] < min || arr[maxIndex] > max) print("0 ")
        else print(maxIndex - minIndex + 1); print(" ")
    }
}
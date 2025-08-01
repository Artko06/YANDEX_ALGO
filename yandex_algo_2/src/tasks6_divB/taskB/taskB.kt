package tasks6_divB.taskB

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
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val countTests = readLine()!!.toInt()
    val tests = readLine()!!.split(" ").map { it.toInt() }

    tests.forEach { num ->
        val left = lBinSearch(num, arr)
        val right = rBinSearch(num, arr)

        if (arr[left] != num || arr[right] != num) {
            println("0 0")
        } else {
            println("${left + 1} ${right + 1}")
        }
    }
}
package tasks6_divB.taskD

fun lBinSearch(a: Long, k: Long, b: Long, m: Long, x: Long): Long {
    var left = 1L
    var right = 2 * x / (if (a > b) a else b)

    while (left < right) {
        val days = (left + right) / 2
        val workDaysA = days - days / k
        val workDaysB = days - days / m

        if (workDaysA * a + workDaysB * b < x) left = days + 1
        else right = days
    }

    return left
}

fun main() {
    val (a, k, b, m, x) = readLine()!!.split(" ").map { it.toLong() }

    println(lBinSearch(a, k, b, m, x))
}
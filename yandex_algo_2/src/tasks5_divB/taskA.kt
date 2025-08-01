package tasks5_divB

fun prefixSum(array: List<Long>): List<Long> {
    val prefSum = MutableList(array.size + 1) {0L}

    for(i in 1 until prefSum.size) {
        prefSum[i] = prefSum[i - 1] + array[i - 1]
    }
    return prefSum
}

fun main() {
    val (countNums, countTests) = readLine()!!.trim().split(" ").map { it.toInt() }
    val prefSum = prefixSum(readLine()!!.trim().split(" ").map { it.toLong() })

    repeat(countTests) {
        val (start, end) = readLine()!!.trim().split(" ").map { it.toInt() }

        println(prefSum[end] - prefSum[start - 1])
    }
}
package tasks6_divB.taskE

fun check(l: Long, k: Int, nums: List<Long>): Boolean {
    var tempK = 1
    var startNum = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] - startNum > l) {
            tempK++
            startNum = nums[i]

            if (k < tempK) return false
        }
    }

    return true
}

fun lBinSearch(k: Int, nums: List<Long>): Long {
    var left = 0L
    var right = nums.last() - nums.first()

    while (left < right) {
        val mid = (left + right) / 2

        if (check(mid, k, nums)) right = mid
        else left = mid + 1
    }

    return left
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val nums = readLine()!!.split(" ").map { it.toLong() }.sorted()

    println(lBinSearch(k, nums))
}
package tasks5_divB

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.trim().split(" ").map { it.toLong() }

    var maxSum = nums[0]
    var sum = 0L
    for (num in nums) {
        sum += num

        if (sum > maxSum) maxSum = sum
        if (sum < 0) sum = 0
    }

    println(maxSum)
}
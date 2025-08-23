package dynamic

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val nails = readln().trim().split(' ').map { it.toInt() }.sorted()

    val dp = MutableList(n) {0}
    dp[1] = nails[1] - nails[0]
    if (n > 2) dp[2] = dp[1] + nails[2] - nails[1]

    for (i in 3 until n) {
        dp[i] = min(dp[i - 2] + nails[i] - nails[i - 1], dp[i - 1] + nails[i] - nails[i - 1])
    }

    println(dp[n - 1])
}
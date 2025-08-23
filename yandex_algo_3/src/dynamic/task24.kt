package dynamic

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val times = mutableListOf<Triple<Int, Int, Int>>()

    repeat(n) {
        val (a, b, c) = readln().trim().split(' ').map { it.toInt() }
        times.add(Triple(a, b, c))
    }

    val dp = MutableList(n + 1) {0}
    dp[1] = times[0].first
    if (n > 1) dp[2] = min(dp[1] + times[1].first, times[0].second)
    if (n > 2) dp[3] = minOf(dp[2] + times[2].first, times[0].first + times[1].second, times[0].third)

    if (n > 3){
        for (i in 4..n) {
            dp[i] = minOf(dp[i - 1] + times[i - 1].first, dp[i - 2] + times[i - 2].second, dp[i - 3] + times[i - 3].third)
        }
    }

    println(dp[n])
}
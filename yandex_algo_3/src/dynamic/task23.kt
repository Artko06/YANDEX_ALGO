package dynamic

import kotlin.Int.Companion.MAX_VALUE

fun main() {
    val n = readln().toInt()
    val dp = MutableList(n + 1) {MAX_VALUE}
    val prev = MutableList(n + 1) {0}
    dp[1] = 0

    for (i in 2..n) {
        if (i % 3 == 0) {
            val num = i / 3
            if (dp[num] + 1 < dp[i]) {
                dp[i] = dp[num] + 1
                prev[i] = num
            }
        }
        if (i % 2 == 0) {
            val num = i / 2
            if (dp[num] + 1 < dp[i]) {
                dp[i] = dp[num] + 1
                prev[i] = num
            }
        }
        if (dp[i - 1] + 1 < dp[i]) {
            dp[i] = dp[i - 1] + 1
            prev[i] = i - 1
        }
    }

    val answer = mutableListOf<Int>()
    var temp = n
    while (temp != 0) {
        answer.add(temp)
        temp = prev[temp]
    }

    println(answer.size - 1)
    println(answer.reversed().joinToString(" "))
}
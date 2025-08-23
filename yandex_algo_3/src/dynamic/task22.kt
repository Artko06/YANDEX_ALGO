package dynamic

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
    val dp = MutableList(n + 1) {0}
    dp[1] = 1

    for (i in 2..n) {
        for (j in 1..k) {
            if (i - j < 1) break

            dp[i] += dp[i - j]
        }
    }

    println(dp[n])
}
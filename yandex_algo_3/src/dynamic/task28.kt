package dynamic

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dp = List(n) { MutableList(m) { 0 } }
    dp[0][0] = 1

    for (i in 1 until n) {
        dp[i][0] = 0
    }

    for (i in 1 until m) {
        dp[0][i] = 0
    }

    for (i in 1 until n) {
        for (j in 1 until m) {
            var addNum = 0
            if (i - 2 >= 0) {
               addNum += dp[i - 2][j - 1]
            }

            if (j - 2 >= 0) {
                addNum += dp[i - 1][j - 2]
            }
            dp[i][j] = addNum
        }
    }

    println(dp[n - 1][m - 1])
}
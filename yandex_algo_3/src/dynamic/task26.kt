package dynamic

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val table = MutableList(n) { List(m) { 0 } }
    repeat(n) { row ->
        table[row] = readln().split(" ").map { it.toInt() }
    }

    fun check(food: Int): Boolean {
        val dp = List(n) { MutableList<Int?>(m) { null } }

        dp[0][0] = food - table[0][0]
        for (i in 1 until m) {
            dp[0][i] = dp[0][i - 1]!! - table[0][i]
        }

        for (i in 1 until n) {
            dp[i][0] = dp[i - 1][0]!! - table[i][0]
        }

        for (i in 1 until n) {
            for (j in 1 until m) {
                val topValue = dp[i - 1][j]!!
                val leftValue = dp[i][j - 1]!!

                if (topValue < 0 && leftValue < 0) {
                    dp[i][j] = -1
                } else {
                    if (topValue > leftValue) {
                        dp[i][j] = topValue - table[i][j]
                    } else {
                        dp[i][j] = leftValue - table[i][j]
                    }
                }
            }
        }

        return dp[n - 1][m - 1]!! >= 0
    }

    fun lBinSearch(left: Int, right: Int): Int {
        var left = left
        var right = right

        while (left < right) {
            val mid = (left + right) / 2

            if (check(mid)) {
                right = mid
            } else left = mid + 1
        }

        return left
    }

    println(lBinSearch(0, 40000))
}
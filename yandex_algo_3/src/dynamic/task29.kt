package dynamic

fun main() {
    val n = readln().toInt()
    val money = mutableListOf<Int>()

    if (n == 0) {
        println("0\n0 0")
        return
    }

    repeat(n) {
        money.add(readln().toInt())
    }

    val dp = List(n + 1) { MutableList<Int?>(n + 1) { null } }
    dp[0][0] = 0
    if (money[0] > 100) dp[1][1] = money[0]
    else dp[1][0] = money[0]

    for (i in 2 until n + 1) {
        for (j in 0 until n) {
            if (j - 1 >= 0 && money[i - 1] > 100 && dp[i - 1][j - 1] != null) {
                val newValue = dp[i - 1][j - 1]!! + money[i - 1]

                if (dp[i][j] == null) dp[i][j] = newValue
                else if (dp[i][j] != null && dp[i][j]!! > newValue) {
                        dp[i][j] = newValue
                }
            } else if(money[i - 1] <= 100 && dp[i - 1][j] != null) {
                val newValue = dp[i - 1][j]!! + money[i - 1]

                if (dp[i][j] == null) dp[i][j] = newValue
                else if (dp[i][j] != null && dp[i][j]!! > newValue) {
                    dp[i][j] = newValue
                }
            }

            if (j + 1 < n && dp[i - 1][j + 1] != null) {
                if (dp[i][j] == null) dp[i][j] = dp[i - 1][j + 1]
                else if (dp[i][j] != null && dp[i][j]!! > dp[i - 1][j + 1]!!) {
                    dp[i][j] = dp[i - 1][j + 1]
                }
            }
        }
    }

    var answer = Int.MAX_VALUE
    var noUsedCoupons = 0
    for (i in n downTo 0) {
        if (dp[n][i] != null && dp[n][i]!! < answer) {
            answer = dp[n][i]!!
            noUsedCoupons = i
        }
    }

    val usedCoupons = mutableListOf<Int>()
    var tempColumn = noUsedCoupons
    for(i in n downTo 1) {
        if (
            tempColumn - 1 >= 0 &&
            money[i - 1] > 100 &&
            dp[i][tempColumn]!! - money[i - 1] == dp[i - 1][tempColumn - 1]
            ) {
            tempColumn--
        } else if (dp[i][tempColumn] == dp[i - 1][tempColumn + 1]) {
            tempColumn++
            usedCoupons.add(i)
        }
    }

    println(answer)
    println("$noUsedCoupons ${usedCoupons.size}")
    println(usedCoupons.reversed().joinToString("\n"))
}
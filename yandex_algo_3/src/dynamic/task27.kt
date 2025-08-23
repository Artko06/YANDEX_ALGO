package dynamic

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val table = MutableList(n) { List(m) { 0 } }
    repeat(n) { row ->
        table[row] = readln().split(" ").map { it.toInt() }
    }

    val dp = List(n) { MutableList(m) { 0 } }
    dp[0][0] = table[0][0]
    for (i in 1 until m) {
        dp[0][i] = dp[0][i - 1] + table[0][i]
    }

    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][0] + table[i][0]
    }

    for (i in 1 until n) {
        for (j in 1 until m) {
            val topValue = dp[i - 1][j]
            val leftValue = dp[i][j - 1]

            if (topValue < 0 && leftValue < 0) {
                dp[i][j] = -1
            } else {
                if (topValue > leftValue) {
                    dp[i][j] = topValue + table[i][j]
                } else {
                    dp[i][j] = leftValue + table[i][j]
                }
            }
        }
    }

    val wayTortoise = mutableListOf<Char>()
    var currentRow = n - 1
    var currentColumn = m - 1
    while (currentRow != 0 || currentColumn != 0) {
        if (currentRow == 0) {
            wayTortoise.add('R')
            currentColumn--
        } else if (currentColumn == 0) {
            wayTortoise.add('D')
            currentRow--
        } else {
            if (dp[currentRow][currentColumn - 1] > dp[currentRow - 1][currentColumn]){
                wayTortoise.add('R')
                currentColumn--
            } else{
                wayTortoise.add('D')
                currentRow--
            }

        }
    }

    println(dp[n - 1][m - 1])
    println(wayTortoise.reversed().joinToString(" "))
}
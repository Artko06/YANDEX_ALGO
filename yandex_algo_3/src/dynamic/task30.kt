package dynamic

import kotlin.math.max

fun main() {
    val n1 = readln().trim().toInt()
    val nums1 = readln().trim().split(" ").map { it.toInt() }
    val n2 = readln().trim().toInt()
    val nums2 = readln().trim().split(" ").map { it.toInt() }

    val dp = List(n1 + 1) { MutableList(n2 + 1) { 0 } }

    for (i in 0..n1) {
        dp[i][0] = 0
    }
    for (i in 0..n2) {
        dp[0][i] = 0
    }

    for (i in 1..n1) {
        for (j in 1..n2) {
            if (nums1[i - 1] == nums2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    var currentRow = n1
    var currentColumn = n2
    val answerSequence = mutableListOf<Int>()
    while (currentColumn != 0 && currentRow != 0) {
        if (nums1[currentRow - 1] == nums2[currentColumn - 1]) {
            answerSequence.add(nums1[currentRow - 1])
            currentRow--
            currentColumn--
        } else {
            if (dp[currentRow - 1][currentColumn] > dp[currentRow][currentColumn - 1]) {
                currentRow--
            } else currentColumn--
        }
    }

    println(answerSequence.reversed().joinToString(" "))
}
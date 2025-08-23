package razminka

import kotlin.math.max

fun main() {
    val k = readln().toInt()
    val str = readln()
    val letters = "abcdefghijklmnopqrstuvwxyz" // O(26*N) ~ O(N)


    var maxBeautifulStr = 0
    for (letter in letters) {
        var leftBorder = 0
        var tempK = k

        for (i in str.indices) {
            if (str[i] != letter) {
                tempK--
                while (tempK < 0) {
                    if (str[leftBorder] != letter) {
                        tempK++
                    }
                    leftBorder++
                }
            }

            maxBeautifulStr = max(maxBeautifulStr, i - leftBorder + 1)
        }
    }

    println(maxBeautifulStr)
}
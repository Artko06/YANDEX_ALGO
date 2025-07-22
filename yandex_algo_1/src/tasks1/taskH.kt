package tasks1

import kotlin.math.max
import kotlin.math.min

fun main(){
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()

    val minLine1 = a * (n - 1) + n
    val minLine2 = b * (m - 1) + m

    val maxLine1 = a * (n + 1) + n
    val maxLine2 = b * (m + 1) + m

    val minAnswer = max(minLine1, minLine2)
    val maxAnswer = min(maxLine1, maxLine2)

    if (minAnswer > maxAnswer) print(-1)
    else print("$minAnswer $maxAnswer")
}
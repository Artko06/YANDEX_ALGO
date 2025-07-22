package tasks5

import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val nColor = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()
    val mColor = readLine()!!.split(" ").map { it.toInt() }

    var nPointer = 0
    var mPointer = 0
    var pairNM: Pair<Int, Int> = Pair(nColor[nPointer], mColor[mPointer])
    var minDiff = abs(pairNM.first - pairNM.second)


    while (true) {
        if (nColor[nPointer] > mColor[mPointer]) {
            mPointer++
        } else nPointer++

        if (nPointer == n || mPointer == m) break

        val diff = abs(nColor[nPointer] - mColor[mPointer])

        if (diff < minDiff) {
            minDiff = diff
            pairNM = Pair(nColor[nPointer], mColor[mPointer])
        }
    }

    println("${pairNM.first} ${pairNM.second}")
}
package tasks1_divB

import kotlin.math.abs

fun main() {
    val (n, inStation, outStation) = readLine()!!.split(" ").map { it.toByte() }

    val path1 = abs(outStation - inStation) - 1
    val path2 = n - abs(outStation - inStation) - 1

    if (path1 > path2) println(path2)
    else println(path1)
}
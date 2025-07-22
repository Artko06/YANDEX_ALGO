package tasks1

import kotlin.math.max

fun main(){
    val (l1, h1, l2, h2) = readLine()!!.split(" ").map { it.toInt() }

    val s1 = (h1 + h2) * max(l1, l2)
    val s2 = (l1 + l2) * max(h1, h2)
    val s3 = (h1 + l2) * max(l1, h2)
    val s4 = (l1 + h2) * max(h1, l2)

    when (minOf(s1, s2, s3, s4)) {
        s1 -> println("${h1 + h2} ${max(l1, l2)}")
        s2 -> println("${l1 + l2} ${max(h1, h2)}")
        s3 -> println("${h1 + l2} ${max(l1, h2)}")
        s4 -> println("${l1 + h2} ${max(h1, l2)}")
    }
}
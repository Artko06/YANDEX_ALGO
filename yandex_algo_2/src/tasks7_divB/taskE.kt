package tasks7_divB

import kotlin.math.PI

const val END_ANGLE: Byte = 1
const val START_ANGLE: Byte = 2

fun sector(radius: Double, angle: Double): Double {
    return radius * radius * angle / 2
}

fun main() {
    val n = readLine()!!.toInt()

    var maxRadius1 = 0.0
    var minRadius2 = 10e6
    val events = mutableListOf<Pair<Byte, Double>>()
    repeat(n) {
        val (radius1, radius2, alpha1, alpha2) = readLine()!!.split(" ").map { it.toDouble() } // r2 > r1

        if (radius1 > maxRadius1) maxRadius1 = radius1
        if (radius2 < minRadius2) minRadius2 = radius2
        if (alpha1 > alpha2) {
            events.add(Pair(START_ANGLE, 0.0))
            events.add(Pair(END_ANGLE, 2 * PI))
        }
        events.add(Pair(START_ANGLE, alpha1))
        events.add(Pair(END_ANGLE, alpha2))
    }
    events.sortWith(compareBy({ it.second }, { it.first }))

    var square = 0.0
    if (minRadius2 > maxRadius1) {
        var countIntersection = 0
        var startAngle = 0.0
        events.forEach { (type, angle) ->
            if (type == START_ANGLE) countIntersection++
            else if (type == END_ANGLE && countIntersection == n) {
                val angleBetween = angle - startAngle
                square += sector(minRadius2, angleBetween) - sector(maxRadius1, angleBetween)
                countIntersection--
            }
            else if (type == END_ANGLE) countIntersection--

            if (countIntersection == n) {
                startAngle = angle
            }
        }
    }

    println("%.6f".format(square))
}
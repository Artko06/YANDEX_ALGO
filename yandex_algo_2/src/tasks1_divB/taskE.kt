package tasks1_divB

fun isInsidePoint(d: Int, x: Int, y: Int): Boolean {
    return x >= 0 && y >= 0 && y <= -x + d
}

fun betweenPointsWithoutSqrt(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
}

fun main() {
    val d = readLine()!!.toInt()
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }

    if (isInsidePoint(d, x, y)) println(0)
    else {
        val ax = betweenPointsWithoutSqrt(x, y, 0, 0) // 1 (A(0,0))
        val bx = betweenPointsWithoutSqrt(x, y, d, 0) // 2 (B(d,0))
        val cx = betweenPointsWithoutSqrt(x, y, 0, d) // 3 (C(0,d))

        if (ax <= bx && ax <= cx) println(1)
        else if(bx <= cx) println(2)
        else println(3)
    }
}
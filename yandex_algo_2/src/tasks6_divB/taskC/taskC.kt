package tasks6_divB.taskC

const val EPS = 1e-5

fun func(x: Double, a: Int, b: Int, c: Int, d: Int): Double {
    return a * x * x * x + b * x * x + c * x + d
}

fun fBinSearch(left: Double, right: Double, a: Int, b: Int, c: Int, d: Int): Double {
    var left = left
    var right = right

    while(right - left > EPS) {
        val x = (left + right) / 2

        if (func(x, a, b, c, d) * func(right, a, b, c, d) > 0.0) right = x
        else left = x
    }

    return left
}

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toInt() }

    var right = 1.0
    while (func(right, a, b, c, d) * func(-right, a, b, c, d) >= 0.0) { // Монотонно убывает или возрастает (один раз касается Ox)
        right *= 2
    }
    val left = -right

    println("%.5f".format(fBinSearch(left, right, a, b, c, d)))
}
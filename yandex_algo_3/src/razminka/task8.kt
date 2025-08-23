package razminka

fun main() {
    val k = readln().toInt()

    var maxX = Int.MIN_VALUE
    var maxY = Int.MIN_VALUE
    var minX = Int.MAX_VALUE
    var minY = Int.MAX_VALUE
    repeat(k) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }

        if (x > maxX) maxX = x
        if (y > maxY) maxY = y
        if (x < minX) minX = x
        if (y < minY) minY = y
    }

    println("$minX $minY $maxX $maxY")
}
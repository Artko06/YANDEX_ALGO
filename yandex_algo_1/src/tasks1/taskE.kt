package tasks1

fun getPN(k: Int, m: Int, flatsPerFloor: Int): Pair<Int, Int> {
    val flatsPerEntrance = m * flatsPerFloor
    val p = (k - 1) / flatsPerEntrance + 1
    val floor = ((k - 1) % flatsPerEntrance) / flatsPerFloor + 1
    return p to floor
}

fun decision(k1: Int, m: Int, k2: Int, p2: Int, n2: Int): Pair<Int, Int> {
    val offset = (p2 - 1) * m + (n2 - 1)

    if (offset == 0) {
        return -1 to -1
    }

    val flatsPerFloorMax = (k2 - 1) / offset

    if (flatsPerFloorMax == 0 || (k2 - 1) / flatsPerFloorMax != offset) {
        return -1 to -1
    }

    val flatsPerFloorMin = (k2 - 1) / (offset + 1) + 1

    val (p1_1, n1_1) = getPN(k1, m, flatsPerFloorMin)
    val (p1_2, n1_2) = getPN(k1, m, flatsPerFloorMax)

    val p1 = if (p1_1 == p1_2) p1_1 else 0
    val n1 = if (m == 1) 1 else if (n1_1 == n1_2) n1_1 else 0

    return p1 to n1
}

fun main() {
    val (k1, m, k2, p2, n2) = readLine()!!.split(" ").map { it.toInt() }

    if (n2 > m) {
        println("-1 -1")
        return
    }

    if (p2 == 1 && n2 == 1) {
        if (k1 > k2) {
            println("${if (k1 <= m) 1 else 0} ${if (m == 1) 1 else 0}")
        } else {
            println("$p2 $n2")
        }
    } else {
        val (p1, n1) = decision(k1, m, k2, p2, n2)
        println("$p1 $n1")
    }
}

package tasks5

fun main() {
    val n = readLine()!!.toInt()
    val points = List(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toLong() }
        x to y
    }

    var ans: Long = 0
    for (i in 0 until n) {
        val usedVec = mutableSetOf<Pair<Long, Long>>()
        val neig = mutableListOf<Long>()

        for (j in 0 until n) {
            val vecX = points[i].first - points[j].first
            val vecY = points[i].second - points[j].second
            val lenVec: Long = (vecX * vecX) + (vecY * vecY)
            neig.add(lenVec)

            if (usedVec.contains(vecX to vecY)) {
                ans -= 1
            }

            usedVec.add(-vecX to -vecY)
        }

        neig.sort()
        var right = 0
        for (left in neig.indices) {
            while (right < neig.size && neig[left] == neig[right]) {
                right++
            }
            ans += (right - left - 1)
        }
    }

    println(ans)
}

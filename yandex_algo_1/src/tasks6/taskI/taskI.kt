package tasks6.taskI

fun lBinSearch(n: Int, r: Int, c: Int, heights: List<Int>): Int {
    var left = 0
    var right = heights.last() - heights.first()

    while (left < right) {
        val mid = (left + right) / 2
        if (canFormTeams(n, r, c, mid, heights)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return right
}

fun canFormTeams(n: Int, r: Int, c: Int, maxDiff: Int, heights: List<Int>): Boolean {
    var i = 0
    var teams = 0

    while (i + c - 1 < n) {
        if (heights[i + c - 1] - heights[i] <= maxDiff) {
            teams++
            i += c
            if (teams >= r) return true
        } else {
            i++
        }
    }
    return false
}


fun main() {
    val (n, r, c) = readLine()!!.split(" ").map { it.toInt() }
    var heights = mutableListOf<Int>()

    repeat(n) {
        heights.add(readLine()!!.toInt())
    }
    heights = heights.sorted().toMutableList()

    println(lBinSearch(n, r, c, heights))
}

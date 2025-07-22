package tasks7

import kotlin.math.max

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    var observedTeachers: MutableList<Pair<Int, Int>> = mutableListOf()
    repeat(m) {
        val (startTable, endTable) = readLine()!!.split(" ").map { it.toInt() }
        observedTeachers.add(startTable to endTable)
    }
    observedTeachers.sortBy { it.first }

    var countObservable = 0
    var currentStart = -1
    var currentEnd = -1
    observedTeachers.forEach { (start, end) ->
        if (start > currentEnd) {
            if (currentStart != -1) {
                countObservable += currentEnd - currentStart + 1
            }

            currentStart = start
            currentEnd = end
        } else {
            currentEnd = max(currentEnd, end)
        }
    }

    if (currentStart != -1) {
        countObservable += currentEnd - currentStart + 1
    }

    println(n - countObservable)
}
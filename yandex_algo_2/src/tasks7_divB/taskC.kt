package tasks7_divB

fun main() {
    val m = readLine()!!.trim().toInt()

    val lines = mutableListOf<Pair<Int, Int>>()
    while (true) {
        val (left, right) = readLine()!!.trim().split(regex = Regex("\\s+")).map { it.toInt() }

        if (left == 0 && right == 0) break

        if (left < m && right > 0) {
            lines.add(Pair(left, right))
        }
    }
    lines.sortBy { it.first }

    var rightCovered = 0
    val solutionLines = mutableListOf<Pair<Int, Int>>()
    var bestPair = Pair(0, 0)
    for ((left, right) in lines) {
        if (bestPair != Pair(0, 0) && left > rightCovered) {
            rightCovered = bestPair.second
            solutionLines.add(bestPair)

            val rightBorder = bestPair.second
            bestPair = Pair(0, 0)
            if (rightBorder >= m) break
        }

        if (bestPair == Pair(0, 0) && left > rightCovered) {
            solutionLines.clear()
            break
        }

        if (left <= rightCovered && right > bestPair.second) {
            bestPair = Pair(left, right)
        }
    }

    if (bestPair != Pair(0, 0) && bestPair.second >= m) solutionLines.add(bestPair)

    if(solutionLines.isNotEmpty()) {
        println(solutionLines.size)
        solutionLines.forEach { (left, right) ->
            println("$left $right")
        }
    } else {
        println("No solution")
    }
}
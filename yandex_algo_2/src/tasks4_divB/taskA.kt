package tasks4_divB

fun main() {
    val n = readLine()!!.toInt()
    val sumColors = mutableMapOf<Long, Long>()

    val reader = System.`in`.bufferedReader()
    reader.lineSequence().forEach { line ->
        val (color, num) = line.split(" ").map { it.toLong() }

        val valueColor = sumColors.getOrDefault(color, 0)
        sumColors[color] = valueColor + num
    }

    sumColors.toSortedMap().forEach { (color, num) ->
        println("$color $num")
    }
}
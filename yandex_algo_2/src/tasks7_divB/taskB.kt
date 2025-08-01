package tasks7_divB

const val LEAVE: Byte = 1
const val ARRIVE: Byte = 2

fun main() {
    val n = readLine()!!.toInt()

    val arrayTime = mutableListOf<Pair<Byte, Int>>()
    repeat(n) {
        val (arriveTime, timeInspection) = readLine()!!.split(" ").map { it.toInt() }

        arrayTime.add(Pair(ARRIVE, arriveTime))
        arrayTime.add(Pair(LEAVE, arriveTime + timeInspection))
    }
    arrayTime.sortWith(comparator = compareBy({ it.second }, { it.first }))

    var maxCountMachine = 0
    var countMachine = 0
    arrayTime.forEach { (type, _) ->
        if (type == ARRIVE) countMachine++
        else if (type == LEAVE) countMachine--

        if (countMachine > maxCountMachine) maxCountMachine = countMachine
    }

    println(maxCountMachine)
}
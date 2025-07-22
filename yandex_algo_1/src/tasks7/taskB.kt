package tasks7

const val START: Byte = 1
const val POINT: Byte = 2
const val END: Byte = 3

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val events = mutableListOf<Pair<Int, Byte>>()

    repeat(n) {
        val (start, end) = readLine()!!.split(" ").map { it.toInt() }

        if (start > end){
            events.add(Pair(end, START))
            events.add(Pair(start, END))
        } else {
            events.add(Pair(start, START))
            events.add(Pair(end, END))
        }
    }

    val points = readLine()!!.split(" ").map { it.toInt() }
    val pointToCount = mutableMapOf<Int, Int>()
    points.forEach { point ->
        events.add(Pair(point, POINT))
    }

    events.sortWith(compareBy({ it.first }, { it.second }))

    var countSegment = 0
    events.forEach { (point, typeEvent) ->
        when (typeEvent) {
            START -> {
                countSegment++
            }
            POINT -> {
                pointToCount.put(point, countSegment)
            }
            END -> {
                countSegment--
            }
        }
    }

    print(points.joinToString(separator = " ") { pointToCount[it]!!.toString() })
}

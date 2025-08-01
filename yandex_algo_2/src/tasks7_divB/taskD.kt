package tasks7_divB

const val START: Byte = 1
const val CAT: Byte = 2
const val END: Byte = 3

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val events = readLine()!!.split(" ").map { Triple(CAT,it.toInt(), -1) }.toMutableList()
    repeat(m) { index ->
        val (start, end) = readLine()!!.split(" ").map { it.toInt() }

        events.add(Triple(START, start, index))
        events.add(Triple(END, end, index))
    }
    events.sortWith(compareBy({ it.second }, { it.first }))

    val counterCats = MutableList(m) { 0 }
    var totalCounterCats = 0
    events.forEach { (type, point, index) ->
        when (type) {
            CAT -> {
                totalCounterCats++
            }
            START -> {
                counterCats[index] = totalCounterCats
            }
            END -> {
                counterCats[index] = totalCounterCats - counterCats[index]
            }
        }
    }

    println(counterCats.joinToString(separator = " "))
}

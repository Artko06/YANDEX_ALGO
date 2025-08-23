package graphs

private const val WHITE = 0
private const val GREY = 1
private const val BLACK = 2

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }

    val graph = List(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        graph[start].add(end)
    }

    val topSort = mutableListOf<Int>()
    val colors = MutableList(v + 1) { WHITE }
    fun topSortDfs(numberV: Int): Boolean {
        colors[numberV] = GREY
        for (neighbor in graph[numberV]) {
            if (colors[neighbor] == GREY) return false
            else if (colors[neighbor] == WHITE) {
                if (!topSortDfs(neighbor)) {
                    return false
                }
            }
        }
        colors[numberV] = BLACK
        topSort.add(numberV)
        return true
    }

    fun topSort(): Boolean {
        for (index in 1..v) {
            if (colors[index] == WHITE) {
                if (!topSortDfs(index))  return false
            }
        }

        return true
    }

    if (!topSort()) println(-1)
    else {
        println(topSort.reversed().joinToString(separator = " "))
    }
}
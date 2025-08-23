package graphs

private const val WHITE = 0
private const val GREY = 1
private const val BLACK = 2

fun main() {
    val v = readln().toInt()

    val graph = List(v + 1) { mutableListOf<Int>() }
    for (numberV in 1..v) {
        val neighbours = readln().split(" ").map { it.toInt() }
        neighbours.forEachIndexed { index, value ->
            if (value == 1) {
                graph[numberV].add(index + 1)
            }
        }
    }

    val colors = MutableList(v + 1) { WHITE }
    val parent = MutableList(v + 1) { -1 }
    var cycleStart = -1
    var cycleEnd = -1

    fun dfs(v: Int, p: Int): Boolean {
        colors[v] = GREY
        for (u in graph[v]) {
            if (u == p) continue // Пропускаем родительскую вершину
            if (colors[u] == WHITE) {
                parent[u] = v
                if (dfs(u, v)) return true
            } else if (colors[u] == GREY) {
                cycleStart = u
                cycleEnd = v
                return true
            }
        }
        colors[v] = BLACK
        return false
    }

    var hasCycle = false
    for (i in 1..v) {
        if (colors[i] == WHITE) {
            if (dfs(i, -1)) {
                hasCycle = true
                break
            }
        }
    }

    if (!hasCycle) {
        println("NO")
    } else {
        val cycle = mutableListOf<Int>()
        var current = cycleEnd
        while (current != cycleStart) {
            cycle.add(current)
            current = parent[current]
        }
        cycle.add(cycleStart)

        println("YES")
        println(cycle.size)
        println(cycle.joinToString(" "))
    }
}
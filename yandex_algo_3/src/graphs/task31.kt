package graphs

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }

    val graph = List(v + 1) { mutableSetOf<Int>() }
    repeat(e) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }
        if (v1 != v2) {
            graph[v1].add(v2)
            graph[v2].add(v1)
        }
    }

    val componentLinkFor1 = mutableListOf<Int>()
    val visitedVertex = MutableList(v + 1) { false }
    fun dfs(graph: List<Set<Int>>, numberV: Int) {
        componentLinkFor1.add(numberV)
        visitedVertex[numberV] = true
        for (neighbour in graph[numberV]) {
            if (!visitedVertex[neighbour]) {
                dfs(graph, neighbour)
            }
        }
    }

    dfs(graph, 1)
    println(componentLinkFor1.size)
    println(componentLinkFor1.sorted().joinToString(separator = " "))
}
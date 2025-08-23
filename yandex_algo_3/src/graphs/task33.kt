package graphs

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }

    val graph = List(v + 1) { mutableListOf<Int>() }
    repeat(e) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    val visited = MutableList(v + 1) { 0 }
    fun dfs(numberV: Int, colorV: Int): Boolean {
        visited[numberV] = colorV
        for (neighbour in graph[numberV]) {
            if (visited[neighbour] == colorV) return false
            if (visited[neighbour] == 0){
                if(!dfs(neighbour, 3 - colorV)) return false
            }
        }
        return true
    }

    fun check(): Boolean {
        for (index in 1..v) {
            if (visited[index] == 0) {
                if (!dfs(index, 1)) {
                    return false
                }
            }
        }
        return true
    }

    when(check()) {
        false -> println("NO")
        true -> println("YES")
    }
}
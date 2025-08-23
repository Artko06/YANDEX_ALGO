package graphs

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }  // v >= 1, e >= 0

    val graph = List(v + 1) { mutableSetOf<Int>() }
    repeat(e) {
        val (v1, v2) = readln().split(" ").map { it.toInt() }
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    val visited = MutableList(v + 1) { false }
    fun dfs(numberV: Int, component: MutableList<Int>) {
        component.add(numberV)
        visited[numberV] = true
        for (neighbor in graph[numberV]) {
            if (!visited[neighbor]) dfs(neighbor, component)
        }
    }

    val components = mutableListOf<List<Int>>()
    fun componentConnectivity() {
        for (index in 1..v) {
            if (!visited[index]) {
                val component = mutableListOf<Int>()
                dfs(index, component)
                components.add(component)
            }
        }
    }

    componentConnectivity()

    val bufferWriter = System.out.bufferedWriter()
    bufferWriter.write("${components.size}\n")
    for (component in components) {
        bufferWriter.write("${component.size}\n")
        bufferWriter.write(component.joinToString(separator = " ", postfix = "\n"))
    }
    bufferWriter.flush()
}
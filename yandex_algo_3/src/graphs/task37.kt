package graphs

import java.util.LinkedList
import java.util.Queue

fun main() {
    val v = readln().trim().toInt()

    val graph = List(v + 1) { mutableListOf<Int>() }
    for(numberV in 1..v) {
        val neighbours = readln().trim().split(" ").map { it.toInt() }
        neighbours.forEachIndexed { index, value ->
            if (value == 1) {
                graph[numberV].add(index + 1)
            }
        }
    }
    val (startV, endV) = readln().trim().split(" ").map { it.toInt() }

    val dist = MutableList(v + 1) { -1 }
    val parent = MutableList(v + 1) { -1 }
    val queue: Queue<Int> = LinkedList()
    queue.add(startV)
    dist[startV] = 0
    fun bfs() {
        while (queue.isNotEmpty()) {
            val element = queue.poll()
            for (neighbour in graph[element]) {
                if (dist[neighbour] == -1) {
                    dist[neighbour] = dist[element] + 1
                    parent[neighbour] = element
                    queue.add(neighbour)
                }
            }
        }
    }

    bfs()
    val answerDist = mutableListOf(endV, )
    var temp = endV
    while (true){
        temp = parent[temp]
        if (temp == -1) break
        else answerDist.add(temp)
    }

    println(dist[endV])
    if (answerDist.size != 1 && dist[endV] != 0) {
        println(answerDist.reversed().joinToString(separator = " "))
    }
}
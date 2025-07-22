package tasks5

fun main() {
    val n = readLine()!!.toInt()
    val powers = readLine()!!.split(" ").map { it.toInt() }
    val m = readLine()!!.toInt()

    val minCostByPower = MutableList(1000){ 1000 }
    repeat(m) {
        val (power, cost) = readLine()!!.split(" ").map { it.toInt() }

        minCostByPower[power - 1] = minOf(cost, minCostByPower[power - 1])
    }

    for(i in minCostByPower.size - 2 downTo 0) {
        minCostByPower[i] = minOf(minCostByPower[i + 1], minCostByPower[i])
    }

    var sum = 0
    powers.forEach { power ->
        sum += minCostByPower[power - 1]
    }

    println(sum)
}
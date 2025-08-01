package tasks5_divB

fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val x = readLine()!!.trim().split(" ").map { it.toInt() }
    val y = readLine()!!.trim().split(" ").map { it.toInt() }

    val groups = x.mapIndexed { index, group ->
        Pair(index, group)
    }.sortedBy { it.second }
    val audiences = y.mapIndexed { index, audience ->
        Pair(index, audience)
    }.sortedBy { it.second }


    val resultGroups = MutableList(n) {0}
    var tempIndexGroup = 0
    for (indexAudience in 0 until m) {
        val (numberGroup, sizeGroup) = groups[tempIndexGroup]
        val (numberAudience, sizeAudience) = audiences[indexAudience]

        if (sizeAudience > sizeGroup) {
            resultGroups[numberGroup] = numberAudience + 1
            tempIndexGroup++
        }
    }

    println(tempIndexGroup)
    println(resultGroups.joinToString(" "))
}
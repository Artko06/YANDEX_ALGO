package tasks7

fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val timesFinished = mutableListOf<Pair<Int, Int>>()
    for(i in 0 until n) {
        val (t, z, y) = readLine()!!.split(" ").map { it.toInt() }

        var tempTime = 0
        var tempBalloon = 0
        while (tempBalloon < m) {
            repeat(z) {
                tempTime += t
                timesFinished.add(Pair(tempTime, i))
            }
            tempTime += y
            tempBalloon += z
        }
    }
    timesFinished.sortBy { it.first }

    val countBalloon = (0 until n).associateWith{ 0 }.toMutableMap()
    var minTime = 0
    var tempBalloon = 0
    for ((time, numberPerson) in timesFinished) {
        minTime = time
        tempBalloon++

        countBalloon[numberPerson] = countBalloon[numberPerson]!! + 1
        if (tempBalloon == m) break
    }

    println(minTime)
    for (i in 0 until n) {
        print(countBalloon[i].toString() + " ")
    }
}
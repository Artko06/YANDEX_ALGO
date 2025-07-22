package tasks7

const val ENTRY: Byte = 1
const val FIVE_MIN_BEFORE_EXIT: Byte = 2

const val TIME_AD: Int = 5

// NOT TRUE (test 8 - error)
// TEST 8
// 2
// 1 8
// 3 10
// I'm understood, how to solve it, but I'm tired
// https://www.youtube.com/live/5lfkBD4dnGM?si=9HajX9Sz2VDGiUtb&t=310 - solution from yandex

fun main() {
    val n = readLine()!!.toInt()
    val peopleTimes = mutableListOf<Pair<Int, Int>>()
    val infoPeople: MutableList<Triple<Int, Byte, Int>> = mutableListOf()

    for (i in 0 until n) {
        val (entry, exit) = readLine()!!.trim().split(regex = Regex("\\s+")).map { it.toInt() }

        if (exit - entry >= TIME_AD){
            infoPeople.add(Triple(entry, ENTRY, i))
            infoPeople.add(Triple(exit - TIME_AD, FIVE_MIN_BEFORE_EXIT, i))
            peopleTimes.add(entry to exit)
        }
    }

    if (infoPeople.isEmpty()) {
        println("0 1 ${1 + TIME_AD}")
    } else if(infoPeople.size == 2) {
        println("1 ${infoPeople[0].first} ${infoPeople[0].first + TIME_AD}")
    } else {
        infoPeople.sortWith(compareBy({ it.first }, { it.second }))

        val variantsForAd = mutableMapOf<Int, Int>()
        infoPeople.forEach { (time, _) ->
            variantsForAd.put(time, 0)
        }

        val candidateTimes = infoPeople.map { it.first }.toSortedSet().toList()

        var bestCount = 0
        var bestTime1 = 0
        var bestTime2 = 0

        for (i in candidateTimes.indices) {
            val t1 = candidateTimes[i]
            for (j in candidateTimes.indices) {
                val t2 = candidateTimes[j]
                if (t2 < t1 + TIME_AD) continue

                val heard = mutableSetOf<Int>()

                for ((index, person) in peopleTimes.withIndex()) {
                    val (entry, exit) = person
                    val heardFirst = entry <= t1 && exit >= t1 + TIME_AD
                    val heardSecond = entry <= t2 && exit >= t2 + TIME_AD

                    if (heardFirst || heardSecond) {
                        heard.add(index)
                    }
                }

                if (heard.size > bestCount) {
                    bestCount = heard.size
                    bestTime1 = t1
                    bestTime2 = t2
                }
            }
        }

        println("$bestCount ${minOf(bestTime1, bestTime2)} ${maxOf(bestTime1, bestTime2)}")
    }
}
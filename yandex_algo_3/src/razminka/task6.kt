package razminka

fun main() {
    val m = readln().toInt()
    val n = readln().toInt()

    val OSs = mutableListOf<Pair<Int, Int>>()
    val workingOSs = (0 until n).toMutableSet()

    repeat(n) { index ->
        val (start, end) = readln().split(" ").map { it.toInt() }
        OSs.add(start to end)
    }

    for(i in 0 until n) {
        for (j in i + 1 until n) {
            if (OSs[i].first <= OSs[j].second && OSs[j].first <= OSs[i].second) {
                workingOSs.remove(i)
            }
        }
    }

    println(workingOSs.size)
}
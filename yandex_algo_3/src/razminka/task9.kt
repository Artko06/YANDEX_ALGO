package razminka

fun main() {
    val (n, m, k) = readln().trim().split(" ").map { it.toInt() }

    val prefix = Array(n + 1) { LongArray(m + 1) }

    for (x in 1..n) {
        val row = readln().trim().split(" ").map { it.toLong() }
        for (y in 1..m) {
            prefix[x][y] = row[y - 1] + prefix[x - 1][y] + prefix[x][y - 1] - prefix[x - 1][y - 1]
        }
    }

    val answer = StringBuilder()
    repeat(k) {
        val (x1, y1, x2, y2) = readln().trim().split(" ").map { it.toInt() }
        val sum = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1]

        answer.append("$sum\n")
    }

    println(answer)
}
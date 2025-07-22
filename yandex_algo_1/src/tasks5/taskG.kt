package tasks5

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val cards = readLine()!!.split(" ").map { it.toInt() }
        .groupingBy{ it }.eachCount().toList().sortedBy { it.first }

    var counter: Long = 0
    var duplicates = 0
    var right = 0
    for (left in 0 until cards.size){
        while (right < cards.size && cards[left].first.toLong() * k >= cards[right].first){
            if (cards[right].second > 1) duplicates++
            right++
        }

        val rangeLR = right - left

        if (cards[left].second > 2) {
            counter++
        }
        if (cards[left].second > 1) {
            counter += (rangeLR - 1).toLong() * 3
            duplicates--
        }
        counter += (rangeLR - 1).toLong() * (rangeLR - 2).toLong() * 3

        counter += duplicates.toLong() * 3
    }

    println(counter)
}
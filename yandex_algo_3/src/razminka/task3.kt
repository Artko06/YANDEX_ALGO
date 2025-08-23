package razminka

fun rBinSearch(stickers: List<Int>, noInterestedNum: Int): Int {
    var left = 0
    var right = stickers.size - 1

    while (left < right) {
        val mid = (left + right + 1) / 2

        if (stickers[mid] < noInterestedNum) left = mid
        else right = mid - 1
    }

    return if (stickers[left] < noInterestedNum) {
        left
    } else {
        -1
    }
}

fun main() {
    val n = readln().toInt()
    val numberStickers = readln().split(" ").map { it.toInt() }.toSortedSet().toList()

    val k = readln().toInt()
    val noInterestedNums = readln().trim().split(" ").map { it.toInt() }

    noInterestedNums.forEach { num ->
        println(rBinSearch(stickers = numberStickers, noInterestedNum = num) + 1)
    }
}
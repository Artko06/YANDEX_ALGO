package tasks5

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val colors = readLine()!!.split(" ").map { it.toInt() }

    val freq = mutableMapOf<Int, Int>()
    var distinct = 0
    var left = 0
    var minLen = n + 1
    var result = Pair(0, n - 1)

    for (right in 0 until n) {
        val color = colors[right]
        freq[color] = freq.getOrDefault(color, 0) + 1
        if (freq[color] == 1) distinct++

        while (distinct == k) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1
                result = Pair(left, right)
            }

            val leftColor = colors[left]
            freq[leftColor] = freq[leftColor]!! - 1
            if (freq[leftColor] == 0) {
                freq.remove(leftColor)
                distinct--
            }
            left++
        }
    }

    println("${result.first + 1} ${result.second + 1}")
}

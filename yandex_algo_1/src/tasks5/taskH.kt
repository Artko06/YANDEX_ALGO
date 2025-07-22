package tasks5

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!

    val freq = IntArray(26)
    var left = 0
    var maxLen = 0
    var startIndex = 0

    for (right in s.indices) {
        val charR = s[right] - 'a'
        freq[charR]++

        while (freq[charR] > k) {
            freq[s[left] - 'a']--
            left++
        }

        if (right - left + 1 > maxLen) {
            maxLen = right - left + 1
            startIndex = left
        }
    }

    println("$maxLen ${startIndex + 1}")
}

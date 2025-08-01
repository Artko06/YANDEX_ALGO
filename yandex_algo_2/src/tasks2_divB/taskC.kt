package tasks2_divB

fun main() {
    val string = readLine()!!
    var cost = 0
    var left = 0
    var right = string.length - 1

    while (left < right) {
        if (string[left] != string[right]) cost++
        left++
        right--
    }

    println(cost)
}
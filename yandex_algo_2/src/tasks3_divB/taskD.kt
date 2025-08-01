package tasks3_divB

fun main() {
    val n = readLine()!!.toInt()
    val possible = BooleanArray(n + 1) { it != 0 }

    while (true) {
        val input1 = readLine()!!
        if (input1 == "HELP") break
        val input2 = readLine()!!

        val nums = input1.split(" ").map { it.toInt() }.toSet()

        if (input2 == "YES") {
            for (num in 1..n) {
                if (num !in nums) possible[num] = false
            }
        } else if (input2 == "NO") {
            for (num in nums) {
                if (num in 1..n) possible[num] = false
            }
        }
    }

    println((1..n).filter { possible[it] }.joinToString(" "))
}

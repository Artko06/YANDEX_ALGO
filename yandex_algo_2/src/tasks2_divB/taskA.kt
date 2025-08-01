package tasks2_divB

fun main() {
    val numbers = mutableListOf<Int>()
    var maxNum = -1

    while (true){
        val num = readLine()!!.toInt()

        if (num == 0) break
        numbers.add(num)

        if (num > maxNum) maxNum = num
    }

    var countMax = 0
    numbers.forEach { number ->
        if (number == maxNum) countMax++
    }

    println(countMax)
}
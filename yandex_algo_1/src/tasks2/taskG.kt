package tasks2

fun main() {
    val array = readLine()!!.trim().split(" ").map { it.toLong() }

    var max1: Long
    var max2: Long
    var min1: Long
    var min2: Long

    if (array[0] > array[1]) {
        max1 = array[0]
        max2 = array[1]
    } else {
        max1 = array[1]
        max2 = array[0]
    }

    min1 = max2
    min2 = max1

    for (i in 2 until array.size) {
        if (array[i] > max1) {
            max2 = max1
            max1 = array[i]
        } else if (array[i] > max2) {
            max2 = array[i]
        }

        if (array[i] < min1) {
            min2 = min1
            min1 = array[i]
        } else if (array[i] < min2) {
            min2 = array[i]
        }
    }

    if (max1 * max2 > min1 * min2) {
        println("$max2 $max1")
    } else {
        println("$min1 $min2")
    }
}
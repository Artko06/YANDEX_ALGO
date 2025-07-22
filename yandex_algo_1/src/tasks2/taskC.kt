package tasks2

import kotlin.math.abs

fun nearestNumber(array: List<Int>, x: Int): Int {
    var nearestNumber = array[0]

    for (i in 1 until array.size) {
        if (abs(array[i] - x) < abs(nearestNumber - x)) nearestNumber = array[i]
    }

    return nearestNumber
}

fun main(){
    val size = readLine()!!.toInt()
    val array = readLine()!!.split(" ").map { it.toInt() }
    val x = readLine()!!.toInt()

    println(nearestNumber(array, x))
}
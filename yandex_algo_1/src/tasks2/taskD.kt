package tasks2

fun countLargerThenNeighbours(array: List<Int>): Int{
    var counter = 0

    for (i in 1 until array.size - 1) {
       if (array[i] > array[i - 1] && array[i] > array[i + 1]) counter++
    }

    return counter
}

fun main(){
    val array = readLine()!!.split(" ").map { it.toInt() }

    println(countLargerThenNeighbours(array))
}
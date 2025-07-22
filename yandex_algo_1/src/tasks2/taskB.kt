package tasks2

fun constantSeq(array: List<Int>): Boolean{
    for (i in 0 until array.size - 1){
        if(array[i] != array[i + 1]) return false
    }

    return true
}

fun ascendingSeq(array: List<Int>): Boolean {
    for (i in 0 until array.size - 1){
        if (array[i] >= array[i + 1]) return false
    }

    return true
}

fun weaklyAscendingSeq(array: List<Int>): Boolean {
    for (i in 0 until array.size - 1){
        if (array[i] > array[i + 1]) return false
    }

    return true
}

fun descendingSeq(array: List<Int>): Boolean {
    for (i in 0 until array.size - 1){
        if (array[i] <= array[i + 1]) return false
    }

    return true
}

fun weaklyDescendingSeq(array: List<Int>): Boolean {
    for (i in 0 until array.size - 1){
        if (array[i] < array[i + 1]) return false
    }

    return true
}

fun main(){
    val array: MutableList<Int> = mutableListOf()

    while (true){
        val input = readLine()!!

        if(input == "-2000000000") break

        array.add(input.toInt())
    }

    when{
        constantSeq(array) -> print("CONSTANT")
        ascendingSeq(array) -> print("ASCENDING")
        weaklyAscendingSeq(array) -> print("WEAKLY ASCENDING")
        descendingSeq(array) -> print("DESCENDING")
        weaklyDescendingSeq(array) -> print("WEAKLY DESCENDING")
        else -> print("RANDOM")
    }
}
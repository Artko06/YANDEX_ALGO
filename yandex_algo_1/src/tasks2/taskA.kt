package tasks2

fun incList(array: List<Int>): Boolean {
    for (i in 0 until array.size - 1) {
        if (array[i] >= array[i + 1]) return false
    }

    return true
}

fun main(){
    val array = readLine()!!.split(" ").map { it.toInt() }

    val incList = incList(array)

    if (incList) print("YES") else print("NO")
}
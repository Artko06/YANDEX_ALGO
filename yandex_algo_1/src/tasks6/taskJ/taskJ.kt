package tasks6.taskJ

fun merge(l: Int, arr1: List<Int>, arr2: List<Int>): Int {
    var first = 0
    var second = 0
    var median = 0

    for(i in 0 until l) {
        if (first < l && arr1[first] < arr2[second]) {
            median = arr1[first]
            first++
        } else {
            median = arr2[second]
            second++
        }
    }

    return median
}

fun main() {
    val (n, l) = readLine()!!.split(" ").map { it.toInt() }
    val arrays = List(n) { readLine()!!.trim().split(" ").map { it.toInt() } }

    val strOutput = StringBuilder()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            strOutput.append(merge(l, arrays[i], arrays[j]).toString() + "\n")
        }
    }

    println(strOutput)
}
package tasks5_divB

fun findTriplet(resultSum: Int, arr1: List<Int>, arr2: List<Int>, arr3: List<Int>) {
    val valueToIndicesArr3 = mutableMapOf<Int, Int>()
    for (j in arr3.indices) {
        val value = arr3[j]
        if (valueToIndicesArr3[value] == null) valueToIndicesArr3[value] = j
    }

    for (i in arr1.indices) {
        for (j in arr2.indices) {
            val needThird = resultSum - arr1[i] -  arr2[j]
            val k = valueToIndicesArr3[needThird]

            if (k != null) {
                println("$i $j $k")
                return
            }
        }
    }

    println(-1)
}

fun main() {
    val resultSum = readLine()!!.toInt()
    val arr1 = readLine()!!.trim().split(" ").map { it.toInt() }.drop(1)
    val arr2 = readLine()!!.trim().split(" ").map { it.toInt() }.drop(1)
    val arr3 = readLine()!!.trim().split(" ").map { it.toInt() }.drop(1)

    findTriplet(resultSum, arr1, arr2, arr3)
}
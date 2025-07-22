package tasks5

fun countSubarraysWithSumK(listNumbersCars: List<Int>, favoriteNum: Int): Int {
    var counter = 0
    val dict: MutableMap<Int, Boolean> = mutableMapOf(0 to true)

    var sum = 0
    for (num in listNumbersCars) {
        sum += num
        counter += if(dict.getOrDefault(sum - favoriteNum, false)) 1 else 0
        dict[sum] = true
    }

    return counter
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arrayCars = readLine()!!.split(" ").map { it.toInt() }

    println(countSubarraysWithSumK(arrayCars, k))
}
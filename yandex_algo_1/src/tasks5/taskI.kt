package tasks5

fun main() {
    val k = readLine()!!.toInt()
    val str = readLine()!!

    var counter: Long = 0
    var tempCounter: Long = 0
    for (i in k until str.length) {
        if (str[i] == str[i - k]) {
            tempCounter++
            counter += tempCounter
        } else tempCounter = 0
    }

    println(counter)
}
package tasks5

fun main() {
    val (n, maxD) = readLine()!!.split(" ").map { it.toInt() }
    val listOfD = readLine()!!.split(" ").map { it.toInt() }

    var pointerLeft = 0
    var pointerRight = 1

    var counter: Long = 0
    while (pointerRight != n) {
        if (listOfD[pointerRight] - listOfD[pointerLeft] > maxD) {
            counter += n - pointerRight
            pointerLeft++
        } else pointerRight++
    }

    println(counter)
}
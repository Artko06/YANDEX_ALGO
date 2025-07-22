package tasks1

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    if (c < 0) println("NO SOLUTION")
    else if (a == 0 && c * c != b) println("NO SOLUTION")
    else if (a == 0 && c * c == b) println("MANY SOLUTIONS")
    else {
        val numerator = c * c - b
        val x = numerator / a

        if (numerator % a != 0) println("NO SOLUTION")
        else if (a * x + b < 0) println("NO SOLUTION")
        else println(numerator / a)
    }
}
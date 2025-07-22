package tasks3

fun main(){
    val setNumbers1 = readLine()!!.split(" ").map { it.first() }.toSet()
    val setNumbers2 = readLine()!!.toSet()

    println((setNumbers2 - setNumbers1).size)
}


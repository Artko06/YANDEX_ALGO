package tasks3_divB

fun main() {
    val uniqueSet = mutableListOf<Int>()
    val repeatedSet = mutableSetOf<Int>()

    readLine()!!.trim().split(" ").map { it.toInt() }.forEach { num ->
        if (num in uniqueSet) {
            uniqueSet.remove(num)
            repeatedSet.add(num)
        }
        else if(num !in repeatedSet) uniqueSet.add(num)
    }

    println(uniqueSet.joinToString(" "))
}
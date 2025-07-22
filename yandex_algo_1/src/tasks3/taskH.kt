package tasks3

fun main(){
    val amountBirds = readLine()!!.toInt()
    val points: List<Pair<Int, Int>> = List(amountBirds) {
        val point = readLine()!!.split(" ")

        point[0].toInt() to point[1].toInt()
    }

    val uniqueX = mutableSetOf<Int>()

    points.forEach {
        if (it.first !in uniqueX) uniqueX.add(it.first)
    }

    println(uniqueX.size)
}
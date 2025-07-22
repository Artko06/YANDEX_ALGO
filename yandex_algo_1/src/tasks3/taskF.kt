package tasks3

fun main() {
    var intimacy = 0
    val gen1 = readLine()!!
    val gen2 = readLine()!!

    val pairsInGen2: MutableSet<String> = mutableSetOf()

    for (i in 0 until gen2.length - 1) {
        val pair = gen2.substring(i..i + 1)
        pairsInGen2.add(pair)
    }

    for (i in 0 until gen1.length - 1) {
        val pair = gen1.substring(i..i + 1)
        if (pair in pairsInGen2) {
            intimacy++
        }
    }

    println(intimacy)
}
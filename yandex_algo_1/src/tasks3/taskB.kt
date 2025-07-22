package tasks3

fun main() {
    val set1 = readLine()!!.split(" ").toSet().map { it.toInt() }
    val set2 = readLine()!!.split(" ").toSet().map { it.toInt() }

    val intersectionSortSet = set1.intersect(set2).sorted()

    intersectionSortSet.forEach {
        print("$it ")
    }
}
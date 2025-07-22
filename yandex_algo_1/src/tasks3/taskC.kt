package tasks3

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val set1 = HashSet<Int>(n)
    val set2 = HashSet<Int>(m)

    repeat(n){
        set1.add(readLine()!!.toInt())
    }

    repeat(m){
        set2.add(readLine()!!.toInt())
    }

    val sortedIntersection = set1.intersect(set2).sorted()
    val onlyInSet1 = (set1 - set2).sorted()
    val onlyInSet2 = (set2 - set1).sorted()

    println(sortedIntersection.size)
    println(sortedIntersection.joinToString(" "))

    println(onlyInSet1.size)
    println(onlyInSet1.joinToString(" "))

    println(onlyInSet2.size)
    println(onlyInSet2.joinToString(" "))
}
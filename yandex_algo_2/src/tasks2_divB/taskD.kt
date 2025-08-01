package tasks2_divB

fun main() {
    val (length, countBlocks) = readLine()!!.trim().split(' ').map { it.toInt() }
    val placeBlocks = readLine()!!.trim().split(' ').map { it.toInt() }.toMutableList()

    val mid = length / 2
    if (length % 2 != 0 && placeBlocks.contains(mid)) {
        println(mid)
    } else {
        var leftBlock = -1

        for (place in placeBlocks) {
            if (place < mid) leftBlock = place
            if (place >= mid) {
                println("$leftBlock $place")
                break
            }
        }
    }
}
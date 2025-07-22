package tasks5

fun getListOfPairs() : List<Pair<Int, Int>> {
    val size = readLine()!!.toInt()

    val listOfPairs: MutableList<Pair<Int, Int>> = MutableList(size) { Pair(0, 0) }

    for (i in 0 until size) {
        val (first, second) = readLine()!!.split(" ").map { it.toInt() }
        listOfPairs[i] = Pair(first, second)
    }

    return listOfPairs
}

fun prefSumHeight(listOfPairsXY: List<Pair<Int, Int>>): List<Int> {
    val prefSumHeight = MutableList(listOfPairsXY.size) { 0 }

    for(i in 1 until prefSumHeight.size){
        val diff = listOfPairsXY[i].second - listOfPairsXY[i - 1].second
        prefSumHeight[i] = prefSumHeight[i - 1] + if(diff > 0) diff else 0
    }

    return prefSumHeight
}

fun prefSumHeightReverse(listOfPairsXY: List<Pair<Int, Int>>): List<Int> {
    val prefSumHeight = MutableList(listOfPairsXY.size) { 0 }


    for(i in prefSumHeight.size - 1 downTo 1) {
        val diff = listOfPairsXY[i - 1].second - listOfPairsXY[i].second
        prefSumHeight[i - 1] = prefSumHeight[i] + if(diff > 0) diff else 0
    }

    return prefSumHeight
}

fun main() {
    val pairXY = getListOfPairs()
    val pairFromTo = getListOfPairs()


    val prefSumHeightLeft = prefSumHeight(pairXY)
    val prefSumHeightRight = prefSumHeightReverse(pairXY)

    pairFromTo.forEach { (from, to) ->
        if (to > from){
            println(prefSumHeightLeft[to - 1] - prefSumHeightLeft[from - 1])
        }
        else {
            println(prefSumHeightRight[to - 1] - prefSumHeightRight[from - 1])
        }
    }

    println(prefSumHeightRight)
}
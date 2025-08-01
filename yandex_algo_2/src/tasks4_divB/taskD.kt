package tasks4_divB

const val PLACES = 450

fun main() {
    var sumVoices = 0
    val listInput: MutableList<Pair<String, Int>> = mutableListOf()
    val reader = System.`in`.bufferedReader()

    reader.lineSequence().forEach { line ->
        val parts = line.split(" ")
        val number = parts.last().toInt()
        val name = parts.dropLast(1).joinToString(" ")

        listInput.add(element = Pair(name, number))
        sumVoices += number
    }

    var sumPlaces = 0
    val selectivePart = sumVoices.toDouble() / PLACES
    val nameToCountMap: MutableMap<String, Pair<Int, Double>> = mutableMapOf()
    listInput.forEach { (name, count) ->
        val fraction = count / selectivePart
        val intPart = fraction.toInt()
        val remainder = fraction - intPart

        nameToCountMap.put(name, Pair(intPart, remainder))
        sumPlaces += intPart
    }

    if (sumPlaces != PLACES) {
        val remainderList = nameToCountMap.map { (name, pair) -> name to pair.second }.sortedByDescending { it.second }

        var indexRemainderList = 0
        while (sumPlaces != PLACES) {
            val nameByIndex = remainderList[indexRemainderList].first
            val getIntRemainderValue = nameToCountMap[nameByIndex]!!
            nameToCountMap[nameByIndex] = Pair(getIntRemainderValue.first + 1, getIntRemainderValue.second)

            sumPlaces++
            if (indexRemainderList++ == remainderList.size) {
                indexRemainderList = 0
            }
        }
    }

    listInput.forEach { (name, _) ->
        println("$name ${nameToCountMap[name]!!.first}")
    }
}
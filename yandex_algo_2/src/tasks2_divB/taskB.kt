package tasks2_divB

import kotlin.math.abs

const val OFFICE = 0
const val HOUSE = 1
const val SHOP = 2

fun main() {
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val indexShops = mutableListOf<Int>()
    val indexHouses = mutableListOf<Int>()

    numbers.forEachIndexed { index, number ->
        if (number == HOUSE) indexHouses.add(index)
        else if (number == SHOP) indexShops.add(index)
    }

    var maxDistance = 0
    indexHouses.forEach { indexHouse ->
        var minDistance = 10
        indexShops.forEach { indexShop ->
            val dist = abs(indexShop - indexHouse)
            if(dist < minDistance) minDistance = dist
        }

        if (minDistance > maxDistance) maxDistance = minDistance
    }

    println(maxDistance)
}
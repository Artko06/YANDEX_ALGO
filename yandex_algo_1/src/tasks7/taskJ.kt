package tasks7

import kotlin.math.abs

const val END_RECT: Byte = 1
const val START_RECT: Byte = 2

data class Block(
    val number: Int,
    val type: Byte,
    val z: Int,
    val area: Int
)

fun main() {
    val (n, w, l) = readLine()!!.split(" ").map { it.toInt() }

    val events = mutableListOf<Block>()
    val totalArea = w * l

    repeat(n) { number -> // number [0, n)
        val coordinates = readLine()!!.split(" ").map { it.toInt() } // x1, y1, z1, x2, y2, z2
        val area = abs(coordinates[3] - coordinates[0]) * abs(coordinates[4] - coordinates[1])
        val startBlock = Block(number + 1, START_RECT, coordinates[2], area)
        val endBlock = Block(number + 1, END_RECT, coordinates[5], area)

        events.add(startBlock)
        events.add(endBlock)
    }

    events.sortWith(compareBy({ it.z }, { it.type }))

    var minCountBlocks = n + 1
    var currentCountBlocks = 0
    var currentArea = 0

    events.forEach { block ->
        if (block.type == START_RECT) {
            currentArea += block.area
            currentCountBlocks++
        } else if (block.type == END_RECT) {
            currentArea -= block.area
            currentCountBlocks--
        }

        if (currentArea == totalArea && currentCountBlocks < minCountBlocks) {
            minCountBlocks = currentCountBlocks
        }
    }

    if (minCountBlocks == n + 1) println("NO")
    else {
        val currentBlocks = mutableSetOf<Int>()

        for (block in events) {
            if (block.type == START_RECT) {
                currentArea += block.area
                currentBlocks.add(block.number)
            } else if (block.type == END_RECT) {
                currentArea -= block.area
                currentBlocks.remove(block.number)
            }

            if (currentArea == totalArea && minCountBlocks == currentBlocks.size) {
                break
            }
        }

        println("YES")
        println(minCountBlocks)
        println(currentBlocks.sorted().joinToString(separator = " "))
    }
}
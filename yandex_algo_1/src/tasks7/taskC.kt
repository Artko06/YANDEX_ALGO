package tasks7

const val TAKING_STUDENT: Byte = 1
const val SILENT_STUDENT: Byte = 2

fun main() {
    val (n, d) = readLine()!!.split(" ").map { it.toInt() }
    val xStudents = readLine()!!.split(" ").map { it.toInt() }

    val dictByType = mutableListOf<Pair<Int, Byte>>()
    xStudents.forEach { x ->
        dictByType.add(x to TAKING_STUDENT)
        dictByType.add(x + d to SILENT_STUDENT)
    }
    dictByType.sortWith(compareBy({it.first}, {it.second}))


    var maxVariant = 1
    var tempVariant = 0
    dictByType.forEach { (_, eventType) ->
        if (eventType == TAKING_STUDENT) {
            tempVariant++

            if (tempVariant > maxVariant) maxVariant = tempVariant
        } else if (eventType == SILENT_STUDENT) tempVariant--
    }

    tempVariant = 1
    val dictByVariant = mutableMapOf<Int, Int>()
    dictByType.forEach { (x, eventType) ->
        if (eventType == TAKING_STUDENT) {
            dictByVariant[x] = tempVariant

            if (tempVariant < maxVariant) tempVariant++
            else tempVariant = 1
        }
    }

    println(maxVariant)
    println(xStudents.joinToString(separator = " ") { x -> dictByVariant[x]!!.toString() })
}
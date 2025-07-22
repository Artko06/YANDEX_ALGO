package tasks7

const val END_WAY: Byte = 1
const val START_WAY: Byte = 2

fun toMinutes(hours: Int, minutes: Int): Int {
    return hours * 60 + minutes
}

fun main() {
    val (n, m) =readLine()!!.split(" ").map { it.toInt() }

    val buses = mutableListOf<Triple<Int, Int, Byte>>()
    var countBusesInCities = MutableList(n) { 0 }
    var countNightBuses = 0
    repeat(m) {
        val (startCity, startTimeStr, endCity, endTimeStr) = readLine()!!.split(" ")

        val (startHours, startMinutes) = startTimeStr.split(":").map { it.toInt() }
        val startTime = toMinutes(hours = startHours, minutes = startMinutes)

        val (endHours, endMinutes) = endTimeStr.split(":").map { it.toInt() }
        val endTime = toMinutes(hours = endHours, minutes = endMinutes)

        if (startTime > endTime) countNightBuses++

        val numberStartCity = startCity.toInt() - 1
        val numberEndCity = endCity.toInt() - 1

        countBusesInCities[numberStartCity] -= 1
        countBusesInCities[numberEndCity] += 1
        buses.add(Triple(startTime, numberStartCity, START_WAY))
        buses.add(Triple(endTime, numberEndCity, END_WAY))
    }


    countBusesInCities.forEach { balance ->
        if (balance != 0) {
            println(-1)
            return
        }
    }

    buses.sortWith(compareBy({ it.first }, { it.third }))

    countBusesInCities = MutableList(n) {0}
    for ((_, city, typeEvent) in buses) {
        if (typeEvent == END_WAY) {
            countBusesInCities[city] += 1
        } else if (typeEvent == START_WAY) {
            if (countBusesInCities[city] > 0) {
                countBusesInCities[city] -= 1
            }
        }
    }

    var minCountBuses = countNightBuses
    for (i in countBusesInCities.indices) {
        minCountBuses += countBusesInCities[i]
    }

    println(minCountBuses)
}
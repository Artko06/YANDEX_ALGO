package tasks7

import kotlin.math.min

fun Int.isLeapYear(): Boolean {
    return this % 4 == 0 && (this % 100 != 0 || this % 400 == 0)
}

fun Triple<Int, Int, Int>.toDays(): Int {
    val months = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30) // without December
    var sumDays = 0

    for (year in 1 until this.third) {
        if (year.isLeapYear()) {
            sumDays += 366
        } else sumDays += 365
    }

    for (month in 1 until this.second) {
        if (month == 2 && this.third.isLeapYear()) sumDays += 28
        else sumDays += months[month - 1]
    }

    return sumDays + this.first
}

const val CAN: Byte = 2
const val CANT: Byte = 1

fun main() {
    val n = readLine()!!.toInt()
    val people = mutableListOf<Triple<Int, Byte, Int>>()

    for (i in 1..n) {
        val inputDates = readLine()!!.trim().split(" ").map { it.toInt() }

        val bornDate18 = Triple(inputDates[0], inputDates[1], inputDates[2] + 18)
        val bornDate80 = Triple(inputDates[0], inputDates[1], inputDates[2] + 80)
        val days18 = bornDate18.toDays()
        val days80 = bornDate80.toDays()

        val deathDate = Triple(inputDates[3], inputDates[4], inputDates[5])
        val deathDays = deathDate.toDays()

        if (days18 < deathDays){
            people.add(Triple(days18, CAN, i))
            people.add(Triple(min(deathDays, days80), CANT, i))
        }
    }

    if (people.isEmpty()) {
        println(0)
        return
    }

    people.sortWith(compareBy( { it.first }, {it.second}))

    val strOutput = StringBuilder()
    val setPeople = mutableSetOf<Int>()
    var newAdd = false
    people.forEach { (_, type, number) ->
        if (type == CAN) {
            setPeople.add(number)
            newAdd = true
        } else if (type == CANT) {
            if (newAdd) {
                strOutput.append(setPeople.joinToString(separator = " ") + "\n")
                newAdd = false
            }

            setPeople.remove(number)
        }
    }

    print(strOutput)
}
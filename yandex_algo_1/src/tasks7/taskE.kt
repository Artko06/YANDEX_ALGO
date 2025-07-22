package tasks7

const val OPEN: Byte = 1
const val CLOSE: Byte = 2

const val FULL_DAY = 1440

fun main() {
    val n = readLine()!!.toInt()
    val timeWorking = mutableListOf<Pair<Int, Byte>>()

    var mustBeOpen = 0
    var tempOpen = 0
    repeat(n) {
        val (hourOpen, minuteOpen, hourClose, minuteClose) = readLine()!!.split(" ").map { it.toInt() }

        val fullOpen = hourOpen * 60 + minuteOpen
        val fullClose = hourClose * 60 + minuteClose

        if (fullOpen != fullClose) {
            if (fullOpen > fullClose) {
                tempOpen++ // working since yesterday
                timeWorking.add(FULL_DAY to CLOSE)
            }

            mustBeOpen++
            timeWorking.add(fullOpen to OPEN)
            timeWorking.add(fullClose to CLOSE)
        }
    }
    timeWorking.sortWith(compareBy({ it.first }, { it.second }))

    var startWorking = 0
    var sumTimeWorking = 0
    for ((time, typeEvent) in timeWorking) {
        when{
            typeEvent == OPEN && tempOpen == mustBeOpen - 1 -> {
                startWorking = time
                tempOpen++
            }
            typeEvent == OPEN -> tempOpen++
            typeEvent == CLOSE && tempOpen != mustBeOpen -> tempOpen--
            typeEvent == CLOSE -> {
                sumTimeWorking += time - startWorking
                tempOpen--
            }
        }
    }

    if (timeWorking.isEmpty()) println(FULL_DAY)
    else println(sumTimeWorking)
}
package tasks2

fun maxMetersIndex(meters: List<Int>): Int {
    var maxIndex = 0
    var maxNum = -1

    for (i in 0 until meters.size) {
        if (meters[i] > maxNum) {
            maxIndex = i
            maxNum = meters[i]
        }
    }

    return maxIndex
}

fun placeVasya(meters: List<Int>): Int {
    var placeVasya = 0
    var metersVasya = 0
    val maxMetersIndex = maxMetersIndex(meters)


    for (i in 1 until meters.size - 1) {
        if (meters[i].toString().last() == '5'
            && maxMetersIndex < i
            && meters[i + 1] < meters[i]
            && meters[i] > metersVasya
        ) {
            metersVasya = meters[i]
        }
    }

    if (metersVasya != 0) {
        val sortedMeters = meters.sortedDescending()
        placeVasya = sortedMeters.indexOf(metersVasya) + 1
    }

    return placeVasya
}

fun main() {
    val n = readLine()!!.toInt()
    val meters = readLine()!!.split(" ").map { it.toInt() }

    print(placeVasya(meters))
}
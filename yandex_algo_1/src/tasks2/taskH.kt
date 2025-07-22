package tasks2

fun main(){
    val array = readLine()!!.trim().split(" ").map { it.toLong() }

    var max1: Long
    var max2: Long
    var max3: Long
    var min1: Long
    var min2: Long

    if (array[0] >= array[1] && array[0] >= array[2]) {
        max1 = array[0]

        if (array[1] >= array[2]) {
            max2 = array[1]
            max3 = array[2]
        } else{
            max2 = array[2]
            max3 = array[1]
        }

    } else if (array[1] >= array[0] && array[1] >= array[2]) {
        max1 = array[1]

        if (array[0] >= array[2]) {
            max2 = array[0]
            max3 = array[2]
        } else {
            max2 = array[2]
            max3 = array[0]
        }
    } else {
        max1 = array[2]

        if (array[0] >= array[1]) {
            max2 = array[0]
            max3 = array[1]
        } else {
            max2 = array[1]
            max3 = array[0]
        }
    }

    min1 = max3
    min2 = max2

    for (i in 3 until array.size) {
        if (array[i] > max1) {
            max3 = max2
            max2 = max1
            max1 = array[i]
        } else if (array[i] > max2) {
            max3 = max2
            max2 = array[i]
        } else if(array[i] > max3){
            max3 = array[i]
        }

        if (array[i] < min1) {
            min2 = min1
            min1 = array[i]
        } else if (array[i] < min2) {
            min2 = array[i]
        }
    }

    if (max1 * max2 * max3 > min1 * min2 * max1) {
        println("$max1 $max2 $max3")
    } else {
        println("$min1 $min2 $max1")
    }
}